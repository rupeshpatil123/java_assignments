import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './components/admin/admin.component';
import { BusinessComComponent } from './components/business-com/business-com.component';
import { CommentsComponent } from './components/comments/comments.component';
import { EntertainmentComponent } from './components/entertainment/entertainment.component';
import { HomeComponent } from './components/home/home.component';
import { InternationalComponent } from './components/international/international.component';
import { LikesCountComponent } from './components/likes-count/likes-count.component';
import { LoginComponent } from './components/login/login.component';
import { NewsFormComponent } from './components/news-form/news-form.component';
import { SignupComponent } from './components/signup/signup.component';
import { SportsComponent } from './components/sports/sports.component';
import { UserComponent } from './components/user/user.component';
import { WelcomeComponent } from './components/welcome/welcome.component';

const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'',component:WelcomeComponent},
  {path:'signup',component:SignupComponent},
  {path:'login',component:LoginComponent},
 
  {path:'sports',component:SportsComponent},
  {path:'entertainment',component:EntertainmentComponent},
  {path:'user',component:UserComponent},
  {path:'admin',component:AdminComponent},
  {path:'addnews',component:NewsFormComponent},
  {path:'comment',component:CommentsComponent},
  {path:'likes',component:LikesCountComponent},
  {path:'business',component:BusinessComComponent},
  {path:'international',component:InternationalComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
