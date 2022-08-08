import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-home-navbar',
  templateUrl: './home-navbar.component.html',
  styleUrls: ['./home-navbar.component.css']
})
export class HomeNavbarComponent implements OnInit {

  loginStatus:boolean
  constructor(private service:NewsServiceService) { }

  ngOnInit(): void {
    this.loginStatus=this.service.getLoggedStatus()

  }
  onLogout(){
    this.service.setUserLoggedOut();
    this.loginStatus=this.service.getLoggedStatus()
    sessionStorage.clear();
  }

}
