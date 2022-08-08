import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { NewsServiceService } from './services/news-service.service';

@Injectable({
  providedIn: 'root'
})
export class NewsGuardGuard implements CanActivate {
  constructor(private service:NewsServiceService){}
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.service.getLoggedStatus();
  }
  
}
