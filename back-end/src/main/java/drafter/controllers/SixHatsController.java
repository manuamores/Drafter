
package drafter.controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import drafter.beans.hatConclusion.HatConclusionBean;
import drafter.beans.hatConclusion.HatConclusionSerializer;
import drafter.beans.model.ModelBean;
import drafter.beans.sixHats.SixHatsBean;
import drafter.beans.sixHats.SixHatsSerializer;
import drafter.domain.Hat;
import drafter.domain.HatConclusion;
import drafter.domain.Meeting;
import drafter.domain.SixHats;
import drafter.services.HatConclusionService;
import drafter.services.HatService;
import drafter.services.MeetingService;
import drafter.services.SixHatsService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/data/sixHats")
public class SixHatsController {

	@Autowired
	private SixHatsService sixHatsService;
	
	@Autowired
	private HatService hatService;
	
	@Autowired
	private HatConclusionService hatConclusionService;
	
	@Autowired
	private MeetingService	meetingService;
	
	@Autowired
	private SimpMessagingTemplate template;
	

	@GetMapping("/{meetingId}")
	public SixHatsBean findMeeting(@PathVariable("meetingId")Integer meetingId) {
		SixHats res = this.sixHatsService.findById(meetingId);
		if(res.getHats().isEmpty()) {
			
			res = sixHatsService.create(res);

		}
		for(Hat hat : res.getHats()) {
			List<HatConclusion> conclusions = new ArrayList<HatConclusion>(hat.getHatConclusions());
			conclusions.sort(new Comparator<HatConclusion>() {

				@Override
				public int compare(HatConclusion o1, HatConclusion o2) {
					return new Integer(o1.getId()).compareTo(new Integer(o2.getId()));
				}
				
			});
			hat.setHatConclusions(conclusions);
			
		}
		SixHatsBean result = new SixHatsSerializer().fromSixHats(res);

		return result;
	}
	
	@PostMapping("/{meetingId}")
	public SixHatsBean save(@PathVariable("meetingId") int meetingId, @RequestBody SixHatsBean sixHats) {
		Meeting meeting = sixHatsService.findById(new Integer(meetingId));
		SixHats result = new SixHatsSerializer().fromBean(sixHats, meeting);
		result.setHats(hatService.reassignHats(result));
		sixHatsService.save(result);
		result.getHats().stream()
						.forEach(hat -> hatService.save(hat));
		SixHatsBean res =new SixHatsSerializer().fromSixHats(result);
		
		return res;
	}
	
	@MessageMapping("/sixHats/save/{hatId}/{meetingId}")
	public void save(@DestinationVariable int hatId, @DestinationVariable int meetingId, ModelBean<HatConclusionBean> bean) {
		Hat hat = hatService.findById(hatId);
		
		HatConclusion hatConclusion = new HatConclusionSerializer().fromBean(hat, bean.getModel());
		List<HatConclusion> conclusions = new ArrayList<HatConclusion>(hatConclusionService.findByHat(hatId));
		hat.setHatConclusions(new ArrayList<HatConclusion>());
		if(hatConclusion.getId() <= 0) {
			conclusions.add(hatConclusion);
			hat.setHatConclusions(conclusions);
			hatService.save(hat);
			hatConclusion = hatConclusionService.save(hatConclusion);
		}
		else {
			Integer index = null;
			for(HatConclusion conclusion : conclusions) {
				if(conclusion.getId() == hatConclusion.getId()) {
					index = conclusions.indexOf(conclusion);
					break;
				}
			}
			
			if(index != null) {
				conclusions.add(index, hatConclusion);
				hat.setHatConclusions(conclusions);
				hatService.save(hat);
				hatConclusion = hatConclusionService.save(hatConclusion);
			}
		}
		
		bean.setModel(new HatConclusionSerializer().fromConclusion(hatConclusion));
		template.convertAndSend("/meeting/" + meetingId, bean);
	}
	
	@MessageMapping("/sixHats/delete/{conclusionId}/{meetingId}")
	public void delete(@DestinationVariable int conclusionId, @DestinationVariable int meetingId, String json) {
		hatConclusionService.delete(conclusionId);
		template.convertAndSend("/meeting/" + meetingId, json);
	}
	
}