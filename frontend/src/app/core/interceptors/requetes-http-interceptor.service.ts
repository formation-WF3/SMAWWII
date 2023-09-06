import {Injectable} from '@angular/core';
import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {catchError, Observable, retry, throwError} from 'rxjs';

@Injectable()
export class RequetesHttpInterceptor implements HttpInterceptor {

  constructor() {
  }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    // const requeteModifiee = req.clone();
    console.log("aller, ou aller-retour ?");
    return next.handle(req)
      .pipe(
        retry(1),
        catchError((erreur: HttpErrorResponse) => {
          let messageErreur = '';
          if (erreur.error instanceof ErrorEvent) {
            // client-side error
            // errorMessage = `Erreur: ${error.error.message}`;
          } else {
            // server-side error
            // errorMessage = `Status: ${error.status}\nMessage: ${error.message}`;
            messageErreur = `Status: ${erreur.status}, Message: ${erreur.error.message}`;
          }
          // console.log(errorMessage)
          return throwError(() => messageErreur);
        })
      )
  }
}
