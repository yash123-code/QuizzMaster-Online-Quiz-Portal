import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExamAlertComponent } from './exam-alert.component';

describe('ExamAlertComponent', () => {
  let component: ExamAlertComponent;
  let fixture: ComponentFixture<ExamAlertComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExamAlertComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExamAlertComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
