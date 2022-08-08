import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './components/admin/admin.component';
import { UserComponent } from './components/user/user.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import {HttpClientModule} from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { HomeComponent } from './components/home/home.component';
import { SportsComponent } from './components/sports/sports.component';
import { EntertainmentComponent } from './components/entertainment/entertainment.component';
import { HomeNavbarComponent } from './components/home-navbar/home-navbar.component';
import { UserNavbarComponent } from './components/user-navbar/user-navbar.component';
import { AdminNavbarComponent } from './components/admin-navbar/admin-navbar.component';
import { NewsFormComponent } from './components/news-form/news-form.component';
import { CommentsComponent } from './components/comments/comments.component';
import { LikesCountComponent } from './components/likes-count/likes-count.component';
import { BusinessComComponent } from './components/business-com/business-com.component';
import { InternationalComponent } from './components/international/international.component'

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    UserComponent,
    WelcomeComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent,
    SportsComponent,
    EntertainmentComponent,
    HomeNavbarComponent,
    UserNavbarComponent,
    AdminNavbarComponent,
    NewsFormComponent,
    CommentsComponent,
    LikesCountComponent,
    BusinessComComponent,
    InternationalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
