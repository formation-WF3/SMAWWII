import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AdminRoutingModule} from './admin-routing.module';
import {AdminListeArticleComponent} from './components/admin-liste-article/admin-liste-article.component';
import {PageAdminComponent} from './pages/page-admin/page-admin.component';


@NgModule({
  declarations: [
    AdminListeArticleComponent,
    PageAdminComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule
  ]
})
export class AdminModule {
}
