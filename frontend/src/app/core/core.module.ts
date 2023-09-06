import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RequetesHttpInterceptor} from "./interceptors/requetes-http-interceptor.service";
import {HTTP_INTERCEPTORS} from "@angular/common/http";


@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS,
      useClass: RequetesHttpInterceptor,
      multi: true
    }
  ],
})
export class CoreModule { }
