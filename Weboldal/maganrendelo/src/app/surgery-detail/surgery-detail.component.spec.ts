import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SurgeryDetailComponent } from './surgery-detail.component';

describe('SurgeryDetailComponent', () => {
  let component: SurgeryDetailComponent;
  let fixture: ComponentFixture<SurgeryDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SurgeryDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SurgeryDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
