import {ComponentFixture, TestBed} from '@angular/core/testing';

import {AdminListeArticleComponent} from './admin-liste-article.component';

describe('AdminArticleComponent', () => {
  let component: AdminListeArticleComponent;
  let fixture: ComponentFixture<AdminListeArticleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminListeArticleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminListeArticleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
