import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/Common/category';
import { ManagementserviceService } from 'src/app/services/managementservice.service';

@Component({
  selector: 'app-category-form',
  templateUrl: './category-form.component.html',
  styleUrls: ['./category-form.component.css']
})
export class CategoryFormComponent implements OnInit {

  category = new Category(0,"");
  categoryList:Category[]
  constructor( private service: ManagementserviceService,private route:Router) { }

  ngOnInit(): void {
  }

  onSubmit(){

    this.service.saveCategory(this.category).subscribe(()=>
    {
      this.route.navigateByUrl("/categories")
    }
    )

  }
   

}
