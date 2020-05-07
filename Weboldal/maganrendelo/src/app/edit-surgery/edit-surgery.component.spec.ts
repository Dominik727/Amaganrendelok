import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditSurgeryComponent } from './edit-surgery.component';

describe('EditSurgeryComponent', () => {
  let component: EditSurgeryComponent;
  let fixture: ComponentFixture<EditSurgeryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditSurgeryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditSurgeryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
