import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Idea } from '../models/idea.model';
import { Observable } from 'rxjs/Observable';
import { environment } from '../../../environments/environment';
import { Meeting } from '../models/meeting.model';
import { RealTimeService } from '../../services/real-time.service';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class IdeaService {

  constructor(private http:HttpClient) {}

  staticUrl:String = environment.baseApi;


  getIdeas(): Observable<Array<Idea>> {
    return this.http.get<Array<Idea>>(this.staticUrl+'/ideas');
  }

  getIdeasByMeeting(meeting: number): Observable<Array<Idea>> {
    return this.http.get<Array<Idea>>(this.staticUrl+'/ideas/list/' + meeting);
  }

  saveIdea(ideas:Idea[], id:number): Observable<Idea> {
    return this.http.post<Idea>(this.staticUrl+'/ideas/'+id,ideas,{});
  }

}
