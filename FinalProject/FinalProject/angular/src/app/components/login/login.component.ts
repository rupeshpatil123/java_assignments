import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Users } from 'src/app/common/users';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isadmin=false;
  isvalid=false;
  email:string
  password:string
  user:Users[]
  constructor(private service:NewsServiceService,private route:Router) { }

  ngOnInit(): void {
    this.getAllUser()
  }

  
  loginSubmit(loginForm:any){
  

      for (let user of  this.user){
        
       
       if(loginForm.email ===  user.emailid && loginForm.password === user.password ){
         
          let userid = user.userid.toString()
          
          sessionStorage.setItem('userid',userid)
          sessionStorage.setItem('emailid',String(user.emailid))
         
          this.service.setLoggedIn();
          this.isvalid=true;
          if(user.isadmin===true){
            this.isadmin=true;
          }
     
        }
      
      }
      if(this.isvalid){
        if(this.isadmin===false){
        this.route.navigateByUrl("/home")
        alert("logged in sucessfuly")
        }
        else{
          this.route.navigateByUrl("/admin")
        }

      }
      
      else{
        alert("Invalid Credientials.......")
       
        // this.route.navigateByUrl("/login")
      }
     
     
    }
    

  
  getAllUser(){
    this.service.getAllUsers().subscribe((data)=>{
      console.log(data);
      
      this.user=data;
    })
  }

}
