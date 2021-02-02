import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditTestComponentComponent } from './edit-test-component.component';

describe('EditTestComponentComponent', () => {
  let component: EditTestComponentComponent;
  let fixture: ComponentFixture<EditTestComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditTestComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EditTestComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
