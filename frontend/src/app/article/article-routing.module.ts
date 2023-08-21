import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {ArticleComponent} from "./pages/article/article.component";
import {ListeArticleComponent} from "./components/liste-article/liste-article.component";

const routes: Routes = [
  {
    path: '', component: ArticleComponent,
    children: [
      {path: '', component: ListeArticleComponent, outlet: 'sidebar-non-contenu'}
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
