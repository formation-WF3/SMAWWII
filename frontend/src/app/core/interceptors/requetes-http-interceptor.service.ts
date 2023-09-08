import {Injectable} from '@angular/core';
import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {catchError, Observable, retry, throwError} from 'rxjs';
import {formatDate} from "@angular/common";
import {AuthService} from "../../auth/services/auth.service";

@Injectable()
export class RequetesHttpInterceptor implements HttpInterceptor {

  constructor(
    private authService: AuthService,
  ) {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const requeteModifiee = req.clone();
    const token = this.authService.getToken();
    if (token) {
      console.log(token);
      requeteModifiee.headers.set("Authorization", "Bearer " + token)
    }
    return next.handle(requeteModifiee).pipe(
      retry(1),
      catchError((erreur: HttpErrorResponse) => {
        let messageErreur = formatDate(new Date, 'dd/MM/yyyy HH:mm', 'fr') + `, ${erreur.error.message}`;
        return throwError(() => messageErreur);
      })
    );
  }
}
