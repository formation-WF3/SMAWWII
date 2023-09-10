import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AuthRoutingModule} from './auth-routing.module';
import {PageEnregistrementComponent} from "./pages/page-enregistrement/page-enregistrement.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AuthService} from "./services/auth.service";
import {PageConnexionComponent} from './pages/page-connexion/page-connexion.component';


@NgModule({
  declarations: [
    PageEnregistrementComponent,
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
