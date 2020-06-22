import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PersoneComponent } from './persone/persone.component';
import { IndrizziComponent } from './indrizzi/indrizzi.component';

@NgModule({
  declarations: [
    AppComponent,
    PersoneComponent,
    IndrizziComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
