import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {path: 'accueil', loadChildren: () => import('./article/article.module').then(module => module.ArticleModule)},
  {path: 'articles', loadChildren: () => import('./article/article.module').then(module => module.ArticleModule)},
  {path: 'auth', loadChildren: () => import('./auth/auth.module').then(module => module.AuthModule)},
  {path: 'admin', loadChildren: () => import('./admin/admin.module').then(module => module.AdminModule)},
  {path: '', redirectTo: '/accueil', pathMatch: 'full'},
  {path: '**', redirectTo: '/accueil'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
