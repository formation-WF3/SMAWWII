import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {EnregistrementFormComponent} from "./components/enregistrement-form/enregistrement-form.component";

const routes: Routes = [
  {path: 'enregistrement', component: EnregistrementFormComponent},
  {path: '', redirectTo: 'enregistrement', pathMatch: 'full'},
  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthRoutingModule {
}
