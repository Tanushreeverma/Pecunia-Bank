import { TestBed } from '@angular/core/testing';

import { CreateServiceService } from './Account.service';

describe('CreateServiceService', () => {
  let service: CreateServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CreateServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
