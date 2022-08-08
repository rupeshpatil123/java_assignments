import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Users } from 'src/app/common/users';
import { NewsServiceService } from 'src/app/services/news-service.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user:Users = new Users(0,"","","",false);
  constructor(private service:NewsServiceService,private route:Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.service.addUser(this.user).subscribe((data)=>{
      console.log(data);
      
      this.route.navigateByUrl('');
    })


  }

}
