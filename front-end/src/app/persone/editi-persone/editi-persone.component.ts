import { Component, OnInit } from '@angular/core';
import { PersonaService } from 'src/app/service/persona.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NumberValueAccessor, NgForm } from '@angular/forms';
import { Persona } from 'src/app/model/persona.model';

@Component({
  selector: 'app-editi-persone',
  templateUrl: './editi-persone.component.html',
  styleUrls: ['./editi-persone.component.css']
})
export class EditiPersoneComponent implements OnInit {

  id: number;
  editPersone: Persona;
  constructor(private service: PersonaService, private route: Router, private actRoute: ActivatedRoute) { }

  ngOnInit(){
      this.id = this.actRoute.snapshot.params.id;
      const edit = this.service.getOne(this.id).subscribe(res =>{
        this.editPersone = res;
      })
  }

  onSubmit(form: NgForm){
    this.editPersone = {

      nome: form.value.nome,
      cognome: form.value.cognome,
      dataDiNascita: form.value.dataDiNascita,
      codiceFiscale: form.value.codiceFiscale,
      password: form.value.password,
      foto: form.value.foto,
      email: form.value.email,
      categoriaProtetta: form.value.categoriaProtetta,
      residenza:  form.value.residenza,
      domicilio: form.value.domicilio
    }

    this.service
    .updateOne(this.editPersone)
    .toPromise()
    .then(()=>{
      this.route.navigateByUrl('persone')
    })
    .catch(()=>{
      alert("Errore in Update Persone");
    });
  }

}
