import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';
import { IndirizziService } from 'src/app/service/indirizzi.service';

@Component({
  selector: 'app-new-persone',
  templateUrl: './new-persone.component.html',
  styleUrls: ['./new-persone.component.css']
})
export class NewPersoneComponent implements OnInit {

  form: FormGroup;
  newPersona: Persona;
  constructor(private service: PersonaService, private serviceIndi: IndirizziService) { }

  ngOnInit() {
    this.form = new FormGroup ({
      nome: new FormControl('',[Validators.required]),
      cognome: new FormControl('',[Validators.required]),
      dataDiNascita: new FormControl(Date,[Validators.required]),
      codiceFiscale: new FormControl('',[Validators.required]),
      password: new FormControl('',[Validators.maxLength(12)]),
      foto: new FormControl('',[Validators.required]),
      email: new FormControl('',[Validators.required]),
      categoriaProtetta: new FormControl([Validators.required]),
      residenza: new FormGroup({
        via: new FormControl('', [Validators.required]),
        specificheVia: new FormControl('', [Validators.required]),
        comune: new FormControl('', [Validators.required])
      }),
      domicilio: new FormGroup({
        via: new FormControl('', [Validators.required]),
        specificheVia: new FormControl('', [Validators.required]),
        comune: new FormControl('', [Validators.required])
      })
    });
  }
}
