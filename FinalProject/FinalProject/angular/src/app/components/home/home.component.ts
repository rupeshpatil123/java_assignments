import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/common/category';
import { Comments } from 'src/app/common/comments';
import { Likes } from 'src/app/common/likes';
import { News } from 'src/app/common/news';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  loginStatus:boolean;
  id = sessionStorage.getItem('userid');
  newsid: number;
  comment: Comments = new Comments("", 0, 0);
  comments: string
  commentbynewsid: Comments[];
  news: News[];
  categories: Category[];
  like:Likes=new Likes(0,0,0);



  constructor(private service: NewsServiceService, private route: Router) { }

  ngOnInit(): void {
    this.listOfNewsCategory();
    this.listOfNews();
    this.loginStatus=this.service.getLoggedStatus();

  }

  listOfNewsCategory() {
    this.service.getAllCategory().subscribe(data => {
      console.log(data);

      this.categories = data;
    })
  }
  listOfNews() {
    this.service.getAllNews().subscribe(data => {
      console.log(data);
      this.news = data;
      console.log("userid" + this.id);

    })
  }
  getCommentsBynewsId(newsid: number) {
    this.service.getCommentsByNewsId(newsid).subscribe(data => {
      this.commentbynewsid = data;
      
    })

  }
  addComments(id: any) {
    console.log(id);
    this.comment.newsid=id;
    this.comment.userid=+this.id!;
    this.service.addComments(this.comment).subscribe(() => {
     alert("commented successfully!!")

      this.route.navigateByUrl('/home')
    })
  }
  addLikes(id:any){
    this.like.userid=+this.id!;
    this.like.newsid=id;
    this.service.addLikes(this.like).subscribe();
    alert("liked successfully!")
  }

}
