import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, map } from 'rxjs';
import { Users } from '../models/user.model';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly apiUrl: string = 'http://localhost:8080/user/api/v1/';

  //import http client
  constructor(private http: HttpClient) { }

  getUsers(): Observable<Users> {
    return this.http.get<Users>(this.apiUrl + 'users');
  }

  addUser(user: any): void {

  }

  updateUser(user: any): void {

  }

  deleteUser(userId: number): void {

  }


   proccessUsers(resp: Users) {
    return {
      id: resp.id,
      phone: resp.phone,
      name: resp.name,
      lastName: resp.lastName,
      email: resp.email,
      jobTitle: resp.jobTitle,
      token: resp.token
    };


  }
  
}
