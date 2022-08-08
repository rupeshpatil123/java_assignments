import { Component, OnInit } from '@angular/core';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-likes-count',
  templateUrl: './likes-count.component.html',
  styleUrls: ['./likes-count.component.css']
})
export class LikesCountComponent implements OnInit {

  likeCount:[number,number][];
  constructor(private service:NewsServiceService) { }

  ngOnInit(): void {
    this.getCountLikes();
  }
  getCountLikes(){
    this.service.getLikeCount().subscribe(data=>{
      console.log(data);
      
      this.likeCount=data;
    })
  }

}
