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
import {EnPartageModule} from "./en-partage/en-partage.module";
import {PageAccueilComponent} from './page-accueil/page-accueil.component';


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
    EnPartageModule,
    HttpClientModule,
    ArticleModule,
    AuthModule
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'fr-FR'}
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
    registerLocaleData(fr.default);
  }
}
