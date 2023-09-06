import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PageEnregistrementComponent} from "./pages/page-enregistrement/page-enregistrement.component";
import {PageConnexionComponent} from "./pages/page-connexion/page-connexion.component";

const routes: Routes = [
  {path: 'enregistrement', component: PageEnregistrementComponent},
  {path: 'connexion', component: PageConnexionComponent},
  {path: '', redirectTo: 'enregistrement', pathMatch: 'full'},
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule {
}
