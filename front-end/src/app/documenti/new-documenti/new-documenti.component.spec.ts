import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewDocumentiComponent } from './new-documenti.component';

describe('NewDocumentiComponent', () => {
  let component: NewDocumentiComponent;
  let fixture: ComponentFixture<NewDocumentiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewDocumentiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewDocumentiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
