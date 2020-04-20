import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateSurgeryComponent } from './create-surgery.component';

describe('CreateSurgeryComponent', () => {
  let component: CreateSurgeryComponent;
  let fixture: ComponentFixture<CreateSurgeryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateSurgeryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateSurgeryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
