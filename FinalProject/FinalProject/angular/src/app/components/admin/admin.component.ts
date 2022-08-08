import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { News } from 'src/app/common/news';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  news:News[]
  constructor(private service:NewsServiceService,private route:Router) { }

  ngOnInit(): void {
    this.listOfNews();
  }

  listOfNews(){
    this.service.getAllNews().subscribe(
      data => {
        console.log(data);
        this.news=data
        
      }
    )
  }


}
