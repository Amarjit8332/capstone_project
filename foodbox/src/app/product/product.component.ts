import { Component, OnInit } from '@angular/core';
import { ProductServiceService } from '../product-service.service';
import { Product } from '../product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit {
addProduct() {
throw new Error('Method not implemented.');
}
  products!: Product[];
productservices: any;
newProduct: any;

  constructor(private productService: ProductServiceService) { }

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts() {
    this.productService.getAllProducts().subscribe(data => {
      this.products = data || [];
    });
  }
}  
