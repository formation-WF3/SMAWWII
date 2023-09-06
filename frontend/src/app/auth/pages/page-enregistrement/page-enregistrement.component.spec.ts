import {ComponentFixture, TestBed} from '@angular/core/testing';

import {PageEnregistrementComponent} from './page-enregistrement.component';

describe('EnregistrementComponent', () => {
  let component: PageEnregistrementComponent;
  let fixture: ComponentFixture<PageEnregistrementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageEnregistrementComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PageEnregistrementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
