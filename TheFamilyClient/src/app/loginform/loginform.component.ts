import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import { UserService } from '../Services/user.service';

@Component({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html',
  styleUrls: ['./loginform.component.css']
})
export class LoginformComponent implements OnInit {

  private loginform: FormGroup;
  public errorMsg;

  constructor(private fb:FormBuilder, private userService:UserService) { }

  ngOnInit() {
    this.loginform = this.fb.group({
      username:[''],
      password:['']
    })
  }

  onSubmit(){
    // this.userService.login(this.loginform.value).subscribe(
    //   response=>{
    //     console.log(response.username + response.password)
    //   },
    //   error =>this.errorMsg = error,
    //   ()=>console.log("COMPLETED")
    // );
    alert("COMPLETED");
  }

}
