import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditiPersoneComponent } from './editi-persone.component';

describe('EditiPersoneComponent', () => {
  let component: EditiPersoneComponent;
  let fixture: ComponentFixture<EditiPersoneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditiPersoneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditiPersoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
