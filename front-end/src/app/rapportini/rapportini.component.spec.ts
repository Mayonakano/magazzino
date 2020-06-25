import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RapportiniComponent } from './rapportini.component';

describe('RapportiniComponent', () => {
  let component: RapportiniComponent;
  let fixture: ComponentFixture<RapportiniComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RapportiniComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RapportiniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
