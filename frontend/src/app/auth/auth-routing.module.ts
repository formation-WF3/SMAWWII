import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {PageInscriptionComponent} from "./pages/page-inscription/page-inscription.component";
import {PageConnexionComponent} from "./pages/page-connexion/page-connexion.component";

const routes: Routes = [
  {path: 'inscription', component: PageInscriptionComponent},
  {path: 'connexion', component: PageConnexionComponent},
  {path: 'deconnexion', redirectTo: '/accueil', pathMatch: 'full'},
  {path: '', redirectTo: 'inscription', pathMatch: 'full'},
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule {
}
