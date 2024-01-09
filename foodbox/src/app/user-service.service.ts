import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private baseUrl = 'http://localhost:8080/users';

  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<any> {
    return this.http.get(`${this.baseUrl}/all`);
  }

  getUserById(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/user/${id}`);
  }

  addUser(user: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/add`, user);
  }

  updateUser(user: any, id: number): Observable<any> {
    return this.http.put(`${this.baseUrl}/user/update/${id}`, user);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/user/delete/${id}`);
  }
  
}
