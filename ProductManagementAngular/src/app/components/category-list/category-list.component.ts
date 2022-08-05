import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/Common/category';
import { ManagementserviceService } from 'src/app/services/managementservice.service';

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  categories:Category[]
  constructor(private service : ManagementserviceService) { }

  ngOnInit(): void {
    this.listOfCategory()

  }
  listOfCategory(){
    this.service.getAllCategory().subscribe(
      data =>{
        console.log(data);
        this.categories=data
        
      }
    )

  }

}
