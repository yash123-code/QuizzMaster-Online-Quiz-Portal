import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionoptionComponent } from './questionoption.component';

describe('QuestionoptionComponent', () => {
  let component: QuestionoptionComponent;
  let fixture: ComponentFixture<QuestionoptionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuestionoptionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QuestionoptionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
