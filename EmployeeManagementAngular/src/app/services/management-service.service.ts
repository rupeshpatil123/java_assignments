import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable,map } from 'rxjs';
import { Department } from '../common/department';
import { Employee } from '../common/employee';

@Injectable({
  providedIn: 'root'
})
export class ManagementServiceService {
  empurl = "http://localhost:8080/api/emp";
  depturl="http://localhost:8080/api/dept";

  constructor( private httpClient : HttpClient) { }

  getAllEmployees(): Observable<Employee[]>{
    console.log(this.httpClient.get<getEmployeeResopnce>(this.empurl).pipe(map(Response => Response._embedded.employees)));
    
    return this.httpClient.get<getEmployeeResopnce>(this.empurl).pipe(map(Response => Response._embedded.employees))
  }
  getAllDepartments(): Observable<Department[]>{
    console.log(this.httpClient.get<getDepartmentResponce>(this.depturl).pipe(map(Response => Response._embedded.departments)));
    return this.httpClient.get<getDepartmentResponce>(this.depturl).pipe(map(Response => Response._embedded.departments))
    
  }
}

interface getEmployeeResopnce{
  _embedded:{
    employees : Employee[];
  }
  
}
interface getDepartmentResponce{
  _embedded:{
    departments : Department[]
  }
}
