import { Component, OnInit } from '@angular/core';
import { News } from 'src/app/common/news';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-business-com',
  templateUrl: './business-com.component.html',
  styleUrls: ['./business-com.component.css']
})
export class BusinessComComponent implements OnInit {

  businesssnews:News[];
  categoryid=3;
  constructor(private service:NewsServiceService) { }
  ngOnInit(): void {
    this.getNewsByCategoryId(this.categoryid);
  }

  getNewsByCategoryId(categoryid:number){
    this.service.getNewsBycategoryid(this.categoryid).subscribe(data=>{
      this.businesssnews=data;
    })

  }

}
