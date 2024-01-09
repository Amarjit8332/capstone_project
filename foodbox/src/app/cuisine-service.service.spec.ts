import { TestBed } from '@angular/core/testing';

import { CuisineServiceService } from './cuisine-service.service';

describe('CuisineServiceService', () => {
  let service: CuisineServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CuisineServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
