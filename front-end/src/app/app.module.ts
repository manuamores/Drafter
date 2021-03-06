import { VoteService } from './componentes/services/vote.service';
import { IdeaService } from './componentes/services/idea.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { NavbarComponent } from './componentes/navbar/navbar.component';
import { FooterComponent } from './componentes/footer/footer.component';
import { NotFoundPageComponent } from './componentes/not-found-page/not-found-page.component';
import { LoginPageComponent } from './componentes/login-page/login-page.component';
import { RegisterPageComponent } from './componentes/register-page/register-page.component';
import { HomePageComponent } from './componentes/home-page/home-page.component';

import {HttpClientModule} from "@angular/common/http";

import { AgendaPageComponent } from './componentes/agenda-page/agenda-page.component';
import { AgendaService } from './componentes/services/agenda.service';
import { UserService } from './componentes/services/user.service';
import { MeetingService } from './componentes/services/meeting.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RealTimeService } from './services/real-time.service';
import { ChatComponent } from './componentes/chat/chat.component';
import { StandardMeetingComponent, StandardComponent, DynamicMeetingComponent, SixHatsMeetingComponent, SixHatsComponent, DynamicMinutesComponent, StandardMinutesPageComponent, IdeasProsConsComponent, BrainstormingComponent } from './componentes/meetings';
import { MeetingPageComponent } from './componentes/meeting-page/meeting-page.component';
import { OrganizationDepartmentPageComponent } from './componentes/organization-department-page/organization-department-page.component';
import { Organization } from './componentes/models/organization.model';
import { OrganizationService } from './componentes/services/organization.service';
import { DynamicMeetingService } from './componentes/services/dynamic-meeting.service';
import { SixHatsService } from './componentes/services/sixhats.service';
import { ListMeetingPageComponent } from './componentes/list-meeting-page/list-meeting-page.component';
import { IdeasCreateComponent } from './componentes/meetings/brainstorming/ideas-create/ideas-create.component';
import { LoginService } from './componentes/services/login.service';
import { RegisterService } from './componentes/services/register.service';
import { BaseRequestOptions } from '@angular/http';
import { PricingComponent } from './componentes/pricing/pricing.component';
import { ChronometerComponent } from './componentes/meetings/chronometer/chronometer.component';
import { IdeaVotePageComponent } from './componentes/meetings/brainstorming/idea-vote-page/idea-vote-page.component';
import { BrainStormingService } from './componentes/services/brainstorming.service';
import { BrainStormingMinutesPageComponent } from './componentes/meetings/brainstorming/minutes-page/minutes-page.component';
import { VideoconferencesComponent } from './componentes/videoconferences/videoconferences.component';
import { ListOrganizationDepartmentPageComponent } from './componentes/list-organization-department-page/list-organization-department-page.component';
import { SixHatsMinutesPageComponent } from './componentes/meetings/six-hats/six-hats-minutes-page/six-hats-minutes-page.component';
import { PaymentSuccessPageComponent } from './componentes/payment-success-page/payment-success-page.component';
import { EditProfilePageComponent } from './componentes/edit-profile-page/edit-profile-page.component';
import { AuthGuard } from './security/auth.guard';
import { ProfilePageComponent } from './componentes/profile-page/profile-page.component';
import { ProfileService } from './componentes/services/profile.service';
import { NotificationsPageComponent } from './componentes/notifications-page/notifications-page.component';
import { WaitingRoomComponent } from './componentes/meetings/dynamic-meeting/waiting-room/waiting-room.component';
import { LegalPageComponent } from './componentes/legal-page/legal-page.component';
import { ConfirmationModalModule } from 'ng-confirmation-modal';
import { LoaderComponent } from './componentes/loader/loader.component';


@NgModule({
  declarations: [
    AppComponent,
    MeetingPageComponent,
    NavbarComponent,
    FooterComponent,
    NotFoundPageComponent,
    LoginPageComponent,
    RegisterPageComponent,
    HomePageComponent,
    AgendaPageComponent,
    ChatComponent,
    StandardMeetingComponent,
    IdeaVotePageComponent, 
    DynamicMeetingComponent,
    DynamicMinutesComponent,
    OrganizationDepartmentPageComponent,
    StandardComponent,
    StandardMinutesPageComponent,
    AgendaPageComponent,
    SixHatsMeetingComponent,
    SixHatsComponent,
    IdeasProsConsComponent,
    BrainstormingComponent,
    PricingComponent,
    IdeasCreateComponent,
    ChronometerComponent,
    BrainStormingMinutesPageComponent,
    ListMeetingPageComponent,
    ChronometerComponent,
    SixHatsMinutesPageComponent,
    VideoconferencesComponent,
    ListOrganizationDepartmentPageComponent,
    PaymentSuccessPageComponent,
    EditProfilePageComponent,
    ProfilePageComponent,
    NotificationsPageComponent,
    WaitingRoomComponent,
    LegalPageComponent,
    LoaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    ConfirmationModalModule.forRoot({
      confirmBtnClass: 'btn btn-success',
      confirmBtnText: 'Confirm',
      cancelBtnClass: 'btn btn-danger',
      cancelBtnText: 'Cancel',
      modalSize: 'lg',
      modalClass: 'some-modal-class'
     })
  ],

  providers: [
    LoginService,
    RegisterService,
    MeetingService,
    AgendaService,
    OrganizationService,
    FormsModule,
    RealTimeService,
    BaseRequestOptions,
    BrainStormingService,
    UserService,
    ReactiveFormsModule,
    DynamicMeetingService,
    SixHatsService,
    IdeaService,
    VoteService,
    ProfileService,
    AuthGuard
  ],  
  bootstrap: [AppComponent]
})
export class AppModule { }