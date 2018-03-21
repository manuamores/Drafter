package drafter.beans.agenda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import drafter.beans.Option;
import drafter.domain.Agenda;
import drafter.domain.Conclusion;
import drafter.domain.Meeting;
import drafter.services.AgendaService;

public class AgendaSerializer {
	
	
	@Autowired
	private AgendaService agendaService;
	
	
	public AgendaBean fromAgenda(Agenda agenda) {
		AgendaBean res = new AgendaBean();
		
		List<Option> conclusion = agenda.getConclusion().stream().map(us -> new Option(new Integer(us.getId()).toString(),us.getConclusion())).collect(Collectors.toList()); 
		res.setConclusion(conclusion);
		
		res.setMeeting(res.getMeeting());
		res.setNumber(res.getNumber());
		res.setDescription(res.getDescription());
		
		return res;
	}
	
	public List<Agenda> fromBean(List<AgendaBean> agendasBean, Meeting meeting) {
		List<Agenda> agendas = new ArrayList<Agenda>();
		
		for(AgendaBean ab: agendasBean) {
			Agenda a = new Agenda();
			a.setNumber(ab.getNumber());
			a.setDescription(ab.getDescription());
			a.setMeeting(meeting);
			a.setConclusion(new ArrayList<Conclusion>());
			meeting.addAgenda(a);
			agendas.add(a);
		}
		
		return agendas;
	}
}
