import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AdminListeArticleComponent} from "./components/admin-liste-article/admin-liste-article.component";
import {PageAdminComponent} from "./pages/page-admin/page-admin.component";

const routes: Routes = [
  {
    path: '', component: PageAdminComponent,
    children: [
      {path: '', component: AdminListeArticleComponent, outlet: 'admin-contenu'}
    ]
  },
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
