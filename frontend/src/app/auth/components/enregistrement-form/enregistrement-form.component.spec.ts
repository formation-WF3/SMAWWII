import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnregistrementFormComponent } from './enregistrement-form.component';

describe('EnregistrementComponent', () => {
  let component: EnregistrementFormComponent;
  let fixture: ComponentFixture<EnregistrementFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnregistrementFormComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnregistrementFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
