import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/common/category';
import { News } from 'src/app/common/news';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-news-form',
  templateUrl: './news-form.component.html',
  styleUrls: ['./news-form.component.css']
})
export class NewsFormComponent implements OnInit {

  news:News=new News(0,"","","","","","",0);
  category:Category[]
  constructor(private service:NewsServiceService,private route:Router) { }

  ngOnInit(): void {
    this.listOfCategory();
  }
  listOfCategory(){
    this.service.getAllCategory().subscribe(data=>{
      this.category=data;
    })

  }


  onSubmit(){ 
    // if(this.isEditable){
    //   this.service.updateProduct(this.product).subscribe
    // }
     this.service.saveNews(this.news).subscribe(()=>{
      this.route.navigateByUrl("/admin")
    })
  }

}
