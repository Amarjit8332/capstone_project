import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserRoleServiceService {
  private baseUrl = 'http://localhost:8080/userRoles';

  constructor(private http: HttpClient) { }

  getAllUserRoles(): Observable<any> {
    return this.http.get(`${this.baseUrl}/all`);
  }
}
