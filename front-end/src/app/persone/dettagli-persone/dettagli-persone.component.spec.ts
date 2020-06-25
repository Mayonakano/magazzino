import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DettagliPersoneComponent } from './dettagli-persone.component';

describe('DettagliPersoneComponent', () => {
  let component: DettagliPersoneComponent;
  let fixture: ComponentFixture<DettagliPersoneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DettagliPersoneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DettagliPersoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
