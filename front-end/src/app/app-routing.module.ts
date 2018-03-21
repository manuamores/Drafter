import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import {ParticipantsPageComponent} from './componentes/participants-page/participants-page.component';
import { NotFoundPageComponent } from './componentes/not-found-page/not-found-page.component';
import { LoginPageComponent } from './componentes/login-page/login-page.component';
import { RegisterPageComponent } from './componentes/register-page/register-page.component';
import { HomePageComponent } from './componentes/home-page/home-page.component';
import { StandardMeetingComponent } from './componentes/meetings/standard-meeting/standard-meeting.component';
import { AgendaPageComponent } from './componentes/agenda-page/agenda-page.component';

const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'participants', component: ParticipantsPageComponent},
  {path: 'login', component: LoginPageComponent},
  {path: 'register', component: RegisterPageComponent},
  {path: 'home', component: HomePageComponent},
  {path: 'meeting/:id', component: StandardMeetingComponent},
  {path: 'agenda/:meetingId', component: AgendaPageComponent},
  {path: '**', component: NotFoundPageComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
