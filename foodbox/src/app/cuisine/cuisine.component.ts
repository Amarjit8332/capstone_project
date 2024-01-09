import { Component, OnInit } from '@angular/core';
import { CuisineServiceService } from '../cuisine-service.service';

@Component({
  selector: 'app-cuisine',
  templateUrl: './cuisine.component.html',
  styleUrl: './cuisine.component.css'
})
export class CuisineComponent implements OnInit{
  cuisines: any[] = [];

  constructor(private cuisineService: CuisineServiceService) { }

  ngOnInit(): void {
    this.getCuisines();
  }

  getCuisines(): void {
    this.cuisineService.getAllCuisines().subscribe(data => {
      this.cuisines = data;
    });
  }

}
