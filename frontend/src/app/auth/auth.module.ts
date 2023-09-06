import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AuthRoutingModule} from './auth-routing.module';
import {EnregistrementFormComponent} from "./components/enregistrement-form/enregistrement-form.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AuthService} from "./services/auth.service";
import {ConnexionFormComponent} from './components/connexion-form/connexion-form.component';


@NgModule({
  declarations: [
    EnregistrementFormComponent,
    ConnexionFormComponent
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
