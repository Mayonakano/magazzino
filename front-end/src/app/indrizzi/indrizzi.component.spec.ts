import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IndrizziComponent } from './indrizzi.component';

describe('IndrizziComponent', () => {
  let component: IndrizziComponent;
  let fixture: ComponentFixture<IndrizziComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IndrizziComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IndrizziComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
