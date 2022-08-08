import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BusinessComComponent } from './business-com.component';

describe('BusinessComComponent', () => {
  let component: BusinessComComponent;
  let fixture: ComponentFixture<BusinessComComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BusinessComComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BusinessComComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
