import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
<<<<<<< Updated upstream
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IndrizziComponent } from './indrizzi/indrizzi.component';
import { NewIndirizzoComponent } from './indrizzi/new-indirizzo/new-indirizzo.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
=======
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DocumentiComponent } from './documenti/documenti.component';
import { DettagliDocumentiComponent } from './documenti/dettagli-documenti/dettagli-documenti.component';
import { NewDocumentiComponent } from './documenti/new-documenti/new-documenti.component';
import { EditiDocumentiComponent } from './documenti/editi-documenti/editi-documenti.component';
import { FormsModule } from '@angular/forms';
import { PersoneComponent } from './persone/persone.component';
import { DettagliPersoneComponent } from './persone/dettagli-persone/dettagli-persone.component';
import { EditiPersoneComponent } from './persone/editi-persone/editi-persone.component';
import { NewPersoneComponent } from './persone/new-persone/new-persone.component';

>>>>>>> Stashed changes

@NgModule({
  declarations: [
    AppComponent,
<<<<<<< Updated upstream
    IndrizziComponent,
    NewIndirizzoComponent
=======
    DocumentiComponent,
    DettagliDocumentiComponent,
    NewDocumentiComponent,
    EditiDocumentiComponent,
    PersoneComponent,
    DettagliPersoneComponent,
    EditiPersoneComponent,
    NewPersoneComponent
>>>>>>> Stashed changes
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
<<<<<<< Updated upstream
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
=======
    FormsModule
>>>>>>> Stashed changes
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
