import { TestBed } from '@angular/core/testing';

import { FlightcompanyService } from './flightcompany.service';

describe('FlightcompanyService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FlightcompanyService = TestBed.get(FlightcompanyService);
    expect(service).toBeTruthy();
  });
});
