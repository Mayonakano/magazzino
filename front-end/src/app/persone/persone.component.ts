import { Component, OnInit, OnDestroy } from '@angular/core';
import {  Subscription } from 'rxjs';
import { Persona } from '../model/persona.model';
import { PersonaService } from '../service/persona.service';
import { IndirizziService } from '../service/indirizzi.service';

@Component({
  selector: 'app-persone',
  templateUrl: './persone.component.html',
  styleUrls: ['./persone.component.css']
})
export class PersoneComponent implements OnInit,OnDestroy {

  listaPersone: Persona[];
  personeSubscription: Subscription;

  constructor(private service: PersonaService) { }


  ngOnInit(){
    this.personeSubscription = this.service.getAll().subscribe(res =>{
        this.listaPersone = res;
    });
  }

  ngOnDestroy(){
    this.personeSubscription.unsubscribe;
  }

  onDelete(id: number){
    this.service
    .delete(id)
    .toPromise()
    .then(()=>{
      this.ngOnDestroy();
    this.ngOnInit();
    })
    .catch(()=>{
      alert("errore in persona onDelete");
    })


  }

}
