import { Component, OnInit } from '@angular/core';
import { News } from 'src/app/common/news';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-sports',
  templateUrl: './sports.component.html',
  styleUrls: ['./sports.component.css']
})
export class SportsComponent implements OnInit {

  sportsnews:News[];
  categoryid=2;
  constructor(private service:NewsServiceService) { }

  ngOnInit(): void {
    this.getNewsByCategoryId(this.categoryid);
  }
   
  getNewsByCategoryId(categoryid:number){
    this.service.getNewsBycategoryid(this.categoryid).subscribe(data=>{
      this.sportsnews=data;
    })

  }

}
