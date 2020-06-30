import { Component, OnInit, OnDestroy } from '@angular/core';
import { DocumentoService } from '../service/documento.service';
import { Documento } from '../model/documento.model';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-documenti',
  templateUrl: './documenti.component.html',
  styleUrls: ['./documenti.component.css']
})
export class DocumentiComponent implements OnInit,OnDestroy {

  listaDocumenti: Documento[];
  documentiSubscription: Subscription;
  
  constructor(private service: DocumentoService) { }


  ngOnInit(){
    this.documentiSubscription = this.service.getAllForIdPersona(1).subscribe(res =>{
      this.listaDocumenti = res;
    })
  }

  ngOnDestroy(){
    this.documentiSubscription.unsubscribe();
  }

  onDelete(id: number){
    this.service.deleteOne(id)
    .toPromise()
    .then(() => {
      this.ngOnDestroy();
      this.ngOnInit();
    })
    .catch(() =>{
      alert("Errore nel delete del documento");
    });
  }

}
