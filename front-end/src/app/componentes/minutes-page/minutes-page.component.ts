import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
import { MeetingService } from '../services/meeting.service';
import { Meeting } from '../models/meeting.model';
import { Agenda } from '../models/agenda.model';
import { Conclusion } from '../models/conclusion.model';
import { Agenda2 } from '../models/agenda.model2';
import { Meeting2 } from '../models/meeting.model2';

@Component({
  selector: 'minutes-page',
  templateUrl: './minutes-page.component.html',
  styleUrls: ['./minutes-page.component.scss']
})
export class MinutesPageComponent implements OnInit {
  
  meeting: Meeting2 = new Meeting2();
  model:any[];
  agendas: Array<Agenda2>;
  conclusions: Array<Conclusion> = [];
  meetingId: number;

  constructor(private meetingService: MeetingService, 
              private activatedRoute: ActivatedRoute) { }

  ngOnInit() {
    this.activatedRoute.params.subscribe((params: Params) => {
      this.meetingId = params['id'];
    });
    this.meetingService.getMeeting(this.meetingId).subscribe(data => {
       this.meeting = data;
    });
    this.meetingService.getAgendas(this.meetingId).subscribe(data => {
      this.agendas = data;
      this.model = [];
      for(let ag of this.agendas){
        var val = {
          agenda: ag,
          conclusion:ag
        }

       
        this.model.push(val);
      }
    });
  };

}