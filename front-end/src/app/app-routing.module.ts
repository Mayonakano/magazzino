import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DocumentiComponent } from './documenti/documenti.component';
import { DettagliDocumentiComponent } from './documenti/dettagli-documenti/dettagli-documenti.component';
import { NewDocumentiComponent } from './documenti/new-documenti/new-documenti.component';
import { PersoneComponent } from './persone/persone.component';
import { DettagliPersoneComponent } from './persone/dettagli-persone/dettagli-persone.component';
import { RapportiniComponent } from './rapportini/rapportini.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { ErrorComponent } from './error/error.component';


const routes: Routes = [
  {path: 'documenti', component: DocumentiComponent},
  {path: 'documenti/dettaglio/:id', component: DettagliDocumentiComponent},
  {path: 'documenti/new', component: NewDocumentiComponent},
  {path: 'persone', component: PersoneComponent},
  {path: 'persone/dettaglio/:id', component: DettagliPersoneComponent},
  {path: 'rapportini/all/:id', component: RapportiniComponent},
  {path: 'header', component: HeaderComponent},
  {path: 'login', component: LoginComponent},
  {path: 'error', component: ErrorComponent},
  {path: 'logout', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
