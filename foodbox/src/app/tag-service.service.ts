import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tag } from './Tag';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TagServiceService {

  private baseUrl = 'http://localhost:8080/tags';

  constructor(private http: HttpClient) { }

  getAllTags(): Observable<any> {
    return this.http.get(`${this.baseUrl}/all`);
  }

  addTags(tag: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/add`, tag);
  }

  updateTagProductCount(tag: any, id: number): Observable<any> {
    return this.http.put(`${this.baseUrl}/tag/update/${id}`, tag);
  }

  deleteTag(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/cuisine/delete/${id}`);
  }
  
}
