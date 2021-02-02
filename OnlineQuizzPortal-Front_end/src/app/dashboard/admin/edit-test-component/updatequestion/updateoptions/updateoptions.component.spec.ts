import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateoptionsComponent } from './updateoptions.component';

describe('UpdateoptionsComponent', () => {
  let component: UpdateoptionsComponent;
  let fixture: ComponentFixture<UpdateoptionsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateoptionsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateoptionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
