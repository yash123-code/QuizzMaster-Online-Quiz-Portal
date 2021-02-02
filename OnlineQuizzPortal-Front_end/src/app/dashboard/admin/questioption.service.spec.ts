import { TestBed } from '@angular/core/testing';

import { QuestioptionService } from './questioption.service';

describe('QuestioptionService', () => {
  let service: QuestioptionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(QuestioptionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
