import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AuthRoutingModule} from './auth-routing.module';
import {PageInscriptionComponent} from "./pages/page-inscription/page-inscription.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AuthService} from "./services/auth.service";
import {PageConnexionComponent} from './pages/page-connexion/page-connexion.component';


@NgModule({
  declarations: [
    PageInscriptionComponent,
    PageConnexionComponent
  ],
  imports: [
    CommonModule,
    AuthRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    AuthService
  ]
})
export class AuthModule {
}
