import { Component, OnInit } from '@angular/core';
import { Users } from '../models/user.model';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-users-dashboard',
  templateUrl: './users-dashboard.component.html',
  styleUrls: ['./users-dashboard.component.css'],
 
})
export class UsersDashboardComponent implements OnInit {
  
  usuarios: Users[] = [];
  

constructor( private userService: UserService) {}

  ngOnInit(): void {
    console.log('ngOnInit user component');
  
    this.userService.getUsers().subscribe((resp: any) => {
      console.log(resp);
      this.usuarios = resp;

    }); 

  }



}
