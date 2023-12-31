import {ComponentFixture, TestBed} from '@angular/core/testing';

import {PageConnexionComponent} from './page-connexion.component';

describe('ConnexionFormComponent', () => {
  let component: PageConnexionComponent;
  let fixture: ComponentFixture<PageConnexionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageConnexionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PageConnexionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
