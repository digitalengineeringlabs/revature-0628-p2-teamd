import { TestBed } from '@angular/core/testing';

import { UidGetterService } from './uid-getter.service';

describe('UidGetterService', () => {
  let service: UidGetterService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UidGetterService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
