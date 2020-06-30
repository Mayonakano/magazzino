import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DocumentiComponent } from './documenti/documenti.component';
import { DettagliDocumentiComponent } from './documenti/dettagli-documenti/dettagli-documenti.component';
import { NewDocumentiComponent } from './documenti/new-documenti/new-documenti.component';
import { PersoneComponent } from './persone/persone.component';
import { DettagliPersoneComponent } from './persone/dettagli-persone/dettagli-persone.component';
import { NewPersoneComponent } from './persone/new-persone/new-persone.component';
import { RapportiniComponent } from './rapportini/rapportini.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { ErrorComponent } from './error/error.component';
import { LogoutComponent } from './logout/logout.component';


@NgModule({
  declarations: [
    AppComponent,
    DocumentiComponent,
    DettagliDocumentiComponent,
    NewDocumentiComponent,
    NewDocumentiComponent,
    PersoneComponent,
    DettagliPersoneComponent,
    NewPersoneComponent,
    NewPersoneComponent,
    RapportiniComponent,
    HeaderComponent,
    LoginComponent,
    ErrorComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
