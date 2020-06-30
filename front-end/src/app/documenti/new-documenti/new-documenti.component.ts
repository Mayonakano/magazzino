import { Component, OnInit } from '@angular/core';
import { Documento } from 'src/app/model/documento.model';
import { DocumentoService } from 'src/app/service/documento.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { Persona } from 'src/app/model/persona.model';
import { PersonaService } from 'src/app/service/persona.service';

@Component({
  selector: 'app-new-documenti',
  templateUrl: './new-documenti.component.html',
  styleUrls: ['./new-documenti.component.css']
})
export class NewDocumentiComponent implements OnInit {

  newDoc: Documento;
  form: FormGroup;
  persone: Persona[];
  persona: Persona;

  constructor(private service: DocumentoService, private rout: Router, private serviceP: PersonaService, private route: ActivatedRoute) { }//qui ci andra' anche la service di Persona



  ngOnInit(){

      const subPersone = this.serviceP.getAll().subscribe(res => {
      this.persone= res;
    });

  }


  onSubmit(form: NgForm){
      this.newDoc = {
        tipologia: form.value.tipolgia,
        fileDocumento: form.value.fileDocumento,
        numeroDocumento: form.value.numeroDocumento,
        dataDiScadenzaDocumento: form.value.dataDiScadenzaDocumento,
        persona: form.value.persona
      }

      this.service
      .addOne(this.newDoc)
      .toPromise()
      .then(()=>{
        this.rout.navigateByUrl('/documenti');
      })
      .catch(()=>{
        alert("errore nel new documenti");
      });
  }

}
