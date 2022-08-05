import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/Common/category';
import { Product } from 'src/app/Common/poduct';
import { ManagementserviceService } from 'src/app/services/managementservice.service';

@Component({
  selector: 'app-product-form',
  templateUrl: './product-form.component.html',
  styleUrls: ['./product-form.component.css']
})
export class ProductFormComponent implements OnInit {

  product = new Product(0,"","","",0,"",0,new Date(),new Date(),0);
  categoryList:Category[]

  constructor(private service: ManagementserviceService, private route:Router) { }

  ngOnInit(): void {
    this.listOfCategories();

  }
  onSubmit(){ 
    this.service.saveProduct(this.product).subscribe(()=>{
      this.route.navigateByUrl("/products")
    })
  }

  listOfCategories(){
    this.service.getAllCategory().subscribe(data =>{
      this.categoryList=data
    })
  }

}
