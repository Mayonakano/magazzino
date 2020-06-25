import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Documento } from 'src/app/model/documento.model';
import { DocumentoService } from 'src/app/service/documento.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-dettagli-documenti',
  templateUrl: './dettagli-documenti.component.html',
  styleUrls: ['./dettagli-documenti.component.css']
})
export class DettagliDocumentiComponent implements OnInit {


  dettagliDoc: Observable<Documento>

  constructor(private service: DocumentoService, private route: ActivatedRoute) { }

  ngOnInit(){
    const id = this.route.snapshot.params.id;
    this.dettagliDoc = this.service.getOne(id);
  }

}
