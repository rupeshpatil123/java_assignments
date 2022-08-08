import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Category } from '../common/category';
import { Comments } from '../common/comments';
import { Likes } from '../common/likes';
import { News } from '../common/news';
import { Users } from '../common/users';

@Injectable({
  providedIn: 'root'
})
export class NewsServiceService {

  newsid:number;
  likecount:number;
  likeCount:[number,number][];


  constructor(private httpclient :HttpClient ) { }
  isUserLoggedIn=false;
  userURL="http://localhost:8080/api/users";
  catURL="http://localhost:8080/api/category";
  newsURL="http://localhost:8080/api/news";
  commentsURL="http://localhost:8080/api/comments";
  likeCountURL="http://localhost:8080/api/likes/search/countLikes";
  likeURL="http://localhost:8080/api/likes";
  

  getAllCategory():Observable<Category[]>{
    return this.httpclient.get<getCategoryResponse>(this.catURL).pipe(map(Response=>Response._embedded.categories))

  }
  getAllNews():Observable<News[]>{

    return this.httpclient.get<getNewsResponse>(this.newsURL).pipe(map(Response=>Response._embedded.news))

  }
  addUser(user:Users):Observable<Users>{
    const httpOptions={
      headers : new HttpHeaders({
        'Content-type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
      })
    };
    return this.httpclient.post<Users>(this.userURL,user,httpOptions);

  }
  getAllUsers():Observable<Users[]>{
    return this.httpclient.get<getUserResponse>(this.userURL).pipe(map(Response=>Response._embedded.userses))

  }
  getNewsBycategoryid(categoryid:number):Observable<News[]>{
    const urlNews="http://localhost:8080/api/news/search/findBycategoryid?categoryid="+categoryid;
    return this.httpclient.get<getNewsResponse>(urlNews).pipe(map(Response=>Response._embedded.news))

  }

  saveNews(news:News):Observable<News>{
    console.log(news);
    const httpOptions={
      headers : new HttpHeaders({
        'Content-type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
      })
    };
    return this.httpclient.post<News>(this.newsURL,news,httpOptions)
    
  }


  getAllComments():Observable<Comments[]>{

    return this.httpclient.get<getCommentsResponse>(this.commentsURL).pipe(map(Response=>Response._embedded.commentses))

  }
  getLikeCount():Observable<any>{

    return this.httpclient.get<newsAndLikeCount>(this.likeCountURL)

  }

  getLoggedStatus(){
    return this.isUserLoggedIn;
  }

  setLoggedIn(){
    this.isUserLoggedIn =true;
  }

  setUserLoggedOut(){
    this.isUserLoggedIn =false;
  }
  getCommentsByNewsId(newsid:number):Observable<Comments[]>{
    const URL="http://localhost:8080/api/comments/search/findBynewsid?newsid="+newsid;
    return this.httpclient.get<getCommentsResponse>(URL).pipe(map(Response=>Response._embedded.commentses))

  }
  addComments(comment:Comments):Observable<Comments>{
    console.log(comment);
    const httpOptions={
      headers : new HttpHeaders({
        'Content-type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
      })
    };
    return this.httpclient.post<Comments>(this.commentsURL,comment,httpOptions)
    
  }
  deleteComment(commentid:number):Observable<Comments>{
    const httpOptions={
      headers : new HttpHeaders({
        'Content-type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
      })
    };
    return this.httpclient.delete<Comments>(this.commentsURL+`/${commentid}`,httpOptions)

  }
  addLikes(like:Likes):Observable<Likes>{
    console.log(like);
    const httpOptions={
      headers : new HttpHeaders({
        'Content-type' : 'application/json',
        'Authorization' : 'auth-token',
        'Access-Control-Allow-Origin' : '*'
      })
    };
    return this.httpclient.post<Likes>(this.likeURL,like,httpOptions)
  }

}
interface getCategoryResponse{
  _embedded:{
    categories:Category[]
  }
}
interface getNewsResponse{
  _embedded:{
    news:News[]
  }
}
interface getUserResponse{
  _embedded:{
    userses:Users[]
  }
}
interface getCommentsResponse{
  _embedded:{
    commentses:Comments[]
  }
}
interface newsAndLikeCount{
  newsid:number;
  likecount:number;
}
