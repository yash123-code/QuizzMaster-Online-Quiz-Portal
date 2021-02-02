import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestlistComponentstud } from './testlist.component';

describe('TestlistComponent', () => {
  let component: TestlistComponentstud;
  let fixture: ComponentFixture<TestlistComponentstud>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TestlistComponentstud ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TestlistComponentstud);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
