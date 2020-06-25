import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DettagliDocumentiComponent } from './dettagli-documenti.component';

describe('DettagliDocumentiComponent', () => {
  let component: DettagliDocumentiComponent;
  let fixture: ComponentFixture<DettagliDocumentiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DettagliDocumentiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DettagliDocumentiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
