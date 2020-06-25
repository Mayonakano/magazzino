import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewPersoneComponent } from './new-persone.component';

describe('NewPersoneComponent', () => {
  let component: NewPersoneComponent;
  let fixture: ComponentFixture<NewPersoneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewPersoneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewPersoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
