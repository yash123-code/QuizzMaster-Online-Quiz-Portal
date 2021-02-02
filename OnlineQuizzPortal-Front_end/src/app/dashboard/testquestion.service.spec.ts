import { TestBed } from '@angular/core/testing';

import { TestquestionService } from './testquestion.service';

describe('TestquestionService', () => {
  let service: TestquestionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TestquestionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
