import { Component, OnInit } from '@angular/core';
import { News } from 'src/app/common/news';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-international',
  templateUrl: './international.component.html',
  styleUrls: ['./international.component.css']
})
export class InternationalComponent implements OnInit {

  internationalsnews:News[];
  categoryid=5;
  constructor(private service:NewsServiceService) { }
  ngOnInit(): void {
    this.getNewsByCategoryId(this.categoryid);
  }

  getNewsByCategoryId(categoryid:number){
    this.service.getNewsBycategoryid(this.categoryid).subscribe(data=>{
      this.internationalsnews=data;
    })

  }

}
