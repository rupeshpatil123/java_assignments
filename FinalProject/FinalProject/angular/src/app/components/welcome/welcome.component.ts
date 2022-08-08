import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/common/category';
import { Comments } from 'src/app/common/comments';
import { News } from 'src/app/common/news';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  comment:Comments=new Comments("",0,0);
  postcomment:string
  commentbynewsid:Comments[];
  news:News[];
  categories:Category[];
  constructor(private service:NewsServiceService) { }

  ngOnInit(): void {
    this.listOfNewsCategory();
    this.listOfNews();
   
  }

  listOfNewsCategory(){
    this.service.getAllCategory().subscribe(data=>{
      console.log(data);
      
      this.categories=data;
    })
  }
  listOfNews(){
    this.service.getAllNews().subscribe(data=>{
      console.log(data);
      this.news=data;
      
    })
  }
  getCommentsBynewsId(newsid:number){
    this.service.getCommentsByNewsId(newsid).subscribe(data=>{
      this.commentbynewsid=data;
    })

  }
  
}
