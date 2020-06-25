import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditiDocumentiComponent } from './editi-documenti.component';

describe('EditiDocumentiComponent', () => {
  let component: EditiDocumentiComponent;
  let fixture: ComponentFixture<EditiDocumentiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditiDocumentiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditiDocumentiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
