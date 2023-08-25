import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PageArticleComponent} from "./pages/page-article/page-article.component";
import {ListeArticleComponent} from "./components/liste-article/liste-article.component";
import {DetailArticleComponent} from "./components/detail-article/detail-article.component";

const routes: Routes = [
  {
    path: '', component: PageArticleComponent,
    children: [
      {path: '', component: ListeArticleComponent, outlet: 'contenu'}
    ]
  },
  {
    path: ':id', component: PageArticleComponent,
    children: [
      {path: '', component: DetailArticleComponent, outlet: 'contenu'}
    ]
  },
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ArticleRoutingModule {
}
