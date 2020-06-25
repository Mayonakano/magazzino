import { Component, OnInit } from '@angular/core';
import { DocumentoService } from 'src/app/service/documento.service';
import { Documento } from 'src/app/model/documento.model';
import { Persona } from 'src/app/model/persona.model';
import { ActivatedRoute, Router } from '@angular/router';
import { PersonaService } from 'src/app/service/persona.service';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';

@Component({
  selector: 'app-editi-documenti',
  templateUrl: './editi-documenti.component.html',
  styleUrls: ['./editi-documenti.component.css']
})
export class EditiDocumentiComponent implements OnInit {
  id: number;
  editDc: Documento;
  form: FormGroup;
  //persone: Persona[];
  constructor(private serviceP: PersonaService, private service: DocumentoService, private actRoute: ActivatedRoute, private route: Router) { }

  async ngOnInit(){
    this.id = this.actRoute.snapshot.params.id;
    const edit = this.service.getOne(this.id).subscribe(res => {
      this.editDc = res;
    });

    //const getDocs = this.serviceP.getAll().subscribe(res =>{
    //this.persone=res;
    //})
  }

  onSubmit(form: NgForm){

      this.editDc = {
        tipologia: form.value.tipologia,
        fileDocumento: form.value.file,
        numeroDocumento: form.value.numeroDocumento,
        dataDiScadenzaDocumento: form.value.dataDiScadenzaDocumento,
        persona: form.value.persona
      }

      this.service
      .updateOne(this.editDc)
      .toPromise()
      .then(()=>{
        this.route.navigateByUrl('documenti');
      })
      .catch(()=>{
        alert('errore nell/edit di documenti');
      });
  }



}
