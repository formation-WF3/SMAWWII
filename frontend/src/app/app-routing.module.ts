import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

const routes: Routes = [
  {path: 'articles', loadChildren: () => import('./article/article.module').then(module => module.ArticleModule)},
  {path: '', redirectTo: '/articles', pathMatch: 'full'},
  {path: '**', redirectTo: '/articles'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
