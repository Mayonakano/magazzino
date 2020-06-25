import { Component, OnInit } from '@angular/core';
import { PersonaService } from 'src/app/service/persona.service';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Persona } from 'src/app/model/persona.model';

@Component({
  selector: 'app-dettagli-persone',
  templateUrl: './dettagli-persone.component.html',
  styleUrls: ['./dettagli-persone.component.css']
})
export class DettagliPersoneComponent implements OnInit {

  dettagliPer: Observable<Persona>

  constructor(private service: PersonaService, private actRout: ActivatedRoute) { }

  ngOnInit(){
    const id = this.actRout.snapshot.params.id;
    this.dettagliPer = this.service.getOne(id);
  }

}
