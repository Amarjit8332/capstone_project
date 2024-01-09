import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from './product';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  private baseUrl = 'http://localhost:8080/products';

  constructor(private httpClient: HttpClient) { }

  getAllProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.baseUrl}/all`);
  }
  

  getProductById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(`${this.baseUrl}/product/${id}`);
  }

  addProduct(product: Product): Observable<Product> {
    return this.httpClient.post<Product>(`${this.baseUrl}/add`, product);
  }

  updateProduct(product: Product, id: number): Observable<Product> {
    return this.httpClient.put<Product>(`${this.baseUrl}/product/update/${id}`, product);
  }

  deleteProduct(id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/product/delete/${id}`);
  }

  searchProducts(searchTerm: string): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.baseUrl}/search/${searchTerm}`);
  }

  getProductsByTag(tag: string): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.baseUrl}/tag/${tag}`);
  }

  getProductsByCuisine(desiredCuisine: string): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.baseUrl}/cuisine/${desiredCuisine}`);
  }
}


