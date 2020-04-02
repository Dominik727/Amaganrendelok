import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClinicListComponent } from './clinic-list.component';

describe('ClinicListComponent', () => {
  let component: ClinicListComponent;
  let fixture: ComponentFixture<ClinicListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClinicListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClinicListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
