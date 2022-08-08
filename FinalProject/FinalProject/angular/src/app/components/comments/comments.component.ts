import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Comments } from 'src/app/common/comments';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {

  comments:Comments[]
  constructor(private service:NewsServiceService,private route:Router) { }

  ngOnInit(): void {
    this.getAllCommentsList();
   
  }

  getAllCommentsList(){
    this.service.getAllComments().subscribe(data=>{
      this.comments=data;
    })
  }
  DeleteComment(commentid:any){
    if(confirm("Do you want to Delete?")){
      this.service.deleteComment(commentid).subscribe(data =>{
        console.log("deleted");
        this.getAllCommentsList();
        
      })
  }

}
}
