import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AuthRoutingModule} from './auth-routing.module';
import {EnregistrementFormComponent} from "./components/enregistrement-form/enregistrement-form.component";
import {ReactiveFormsModule} from "@angular/forms";
import {AuthService} from "./services/auth.service";


@NgModule({
  declarations: [
    EnregistrementFormComponent
  ],
  imports: [
    CommonModule,
    AuthRoutingModule,
    ReactiveFormsModule
  ],
  providers: [
    AuthService
  ]
})
export class AuthModule {
}
