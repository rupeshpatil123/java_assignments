import { Component, OnInit } from '@angular/core';
import { News } from 'src/app/common/news';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-entertainment',
  templateUrl: './entertainment.component.html',
  styleUrls: ['./entertainment.component.css']
})
export class EntertainmentComponent implements OnInit {

  categoryid=4;
  entertainmentnews:News[];
  constructor(private service: NewsServiceService) { }

  ngOnInit(): void {
    this.getNewsByCategoryId(this.categoryid);
  }

  getNewsByCategoryId(categoryid:number){
    this.service.getNewsBycategoryid(categoryid).subscribe(data=>{
      this.entertainmentnews=data;
    })

  }



}
