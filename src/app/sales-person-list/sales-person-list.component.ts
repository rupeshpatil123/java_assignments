import { Component, OnInit } from '@angular/core';
import { Salesperson } from '../salesperson';

@Component({
  selector: 'app-sales-person-list',
  templateUrl: './sales-person-list.component.html',
  styleUrls: ['./sales-person-list.component.css']
})
export class SalesPersonListComponent implements OnInit {

  name : string = "rupesh";

  s1 : Salesperson = new Salesperson("Rupesh","Patil","rupesh@gmail.com",25000,300);

  salesPersonList : Salesperson [] =[this.s1,
  new Salesperson("Rama","Raju","Rama@gmail.com",20000,300),
  new Salesperson("Rama","Raju","Rama@gmail.com",20000,300),
  new Salesperson("Rama","Raju","Rama@gmail.com",20000,300),
 
  

]
formModel : Salesperson = new Salesperson("","","",0,0);


  constructor() { }

  ngOnInit(): void {

  }
  onSubmit(){
    console.log(this.formModel);
    this.salesPersonList.push(this.formModel);
    
  }

}
