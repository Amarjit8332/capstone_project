import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Cuisine } from './cuisine';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CuisineServiceService {

  private baseUrl="http://localhost:8080/cuisine";
  httpclient: any;

  constructor(private http:HttpClient) { }

  getAllCuisines(): Observable<any>{
    return this.http.get('${this.baseUrl}/all')
  }
  addCuisine(cuisine: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/add`, cuisine);
  }

  updateCuisineProductCount(cuisine: any, id: number): Observable<any> {
    return this.http.put(`${this.baseUrl}/update/${id}`, cuisine);
  }

  deleteCuisine(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/delete/${id}`);
  }

 
}
