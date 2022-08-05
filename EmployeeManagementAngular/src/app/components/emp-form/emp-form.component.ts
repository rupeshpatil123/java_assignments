import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/common/employee';
import { EmpListComponent } from '../emp-list/emp-list.component';

@Component({
  selector: 'app-emp-form',
  templateUrl: './emp-form.component.html',
  styleUrls: ['./emp-form.component.css']
})
export class EmpFormComponent implements OnInit {

  formModel = new Employee(0,"","",null,0,0,0,0);
  constructor() { }

  ngOnInit(): void {
  }
  onSubmit(){}

}
