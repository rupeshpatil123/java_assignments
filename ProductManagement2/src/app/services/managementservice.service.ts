import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable,map } from 'rxjs';
import { Category } from '../Common/category';
import { Product } from '../Common/poduct';


@Injectable({
  providedIn: 'root'
})
export class ManagementserviceService {
  producturl ="http://localhost:8080/api/prod";
  categoryurl="http://localhost:8080/api/cat";

  constructor( private httpClient :HttpClient ) { }

  getAllProducts():Observable<Product[]>{
    console.log(this.httpClient.get<getProductResponse>(this.producturl).pipe(map(Response => Response._embedded.products)));
    
    return this.httpClient.get<getProductResponse>(this.producturl).pipe(map(Response => Response._embedded.products));
  }
  getAllCategory():Observable<Category[]>{
    console.log(this.httpClient.get<getCategoryResponse>(this.categoryurl).pipe(map(Response => Response._embedded.categories)));
    
    return this.httpClient.get<getCategoryResponse>(this.categoryurl).pipe(map(Response => Response._embedded.categories));
  }

  saveProduct(product:Product):Observable<Product>{
    console.log(product);
    const httpOptions={
      headers : new HttpHeaders({
        'Content-type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
      })
    };
    return this.httpClient.post<Product>(this.producturl,product,httpOptions)
    
  }
  saveCategory(category: Category):Observable<Category>{
    console.log(category);
    const httpOptions={
      headers : new HttpHeaders({
        'Content-type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
      })
    };
    return this.httpClient.post<Category>(this.categoryurl,category,httpOptions)
    
  }
}
interface getProductResponse{
  _embedded:{
    products:Product[];
  }
}

interface getCategoryResponse{
  _embedded:{
    categories:Category[];
  }
}
