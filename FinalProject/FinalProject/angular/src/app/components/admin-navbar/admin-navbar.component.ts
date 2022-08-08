import { Component, OnInit } from '@angular/core';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-admin-navbar',
  templateUrl: './admin-navbar.component.html',
  styleUrls: ['./admin-navbar.component.css']
})
export class AdminNavbarComponent implements OnInit {

  constructor(private service:NewsServiceService) { }

  ngOnInit(): void {
  }
  onLogout(){
    this.service.setUserLoggedOut()

  }

}
