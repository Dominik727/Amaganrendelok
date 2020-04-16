import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SurgeryListComponent } from './surgery-list.component';

describe('SurgeryListComponent', () => {
  let component: SurgeryListComponent;
  let fixture: ComponentFixture<SurgeryListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SurgeryListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SurgeryListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
