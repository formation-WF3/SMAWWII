import {LOCALE_ID, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import * as fr from '@angular/common/locales/fr';

import {CoreModule} from "./core/core.module";
import {HttpClientModule} from "@angular/common/http";
import {ArticleModule} from "./article/article.module";
import {registerLocaleData} from "@angular/common";
import {AuthModule} from "./auth/auth.module";
import {PageAccueilComponent} from './page-accueil/page-accueil.component';
import {CommentaireModule} from "./article/commentaire/commentaire.module";
import {AuthService} from "./auth/services/auth.service";
import {SharedModule} from "./shared/shared-module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ToastrModule} from "ngx-toastr";


@NgModule({
  declarations: [
    AppComponent,
    PageAccueilComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    CoreModule,
    HttpClientModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    SharedModule,
    ArticleModule,
    AuthModule,
    CommentaireModule
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'fr-FR'},
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
    registerLocaleData(fr.default);
  }
}
