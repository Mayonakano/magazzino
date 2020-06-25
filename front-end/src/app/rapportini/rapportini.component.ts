import { Component, OnInit } from '@angular/core';
import { Rapportino } from '../model/rapportino.model';
import { Subscription } from 'rxjs';
import { RapportinoService } from '../service/rapportino.service';

@Component({
  selector: 'app-rapportini',
  templateUrl: './rapportini.component.html',
  styleUrls: ['./rapportini.component.css']
})

export class RapportiniComponent implements OnInit {

  rapportini: Rapportino[];
  sbRapportino: Subscription;

  constructor(private service: RapportinoService) { }

  ngOnInit() {
    this.getAll();
  }

  ngOnDestroy() {
    this.sbRapportino.unsubscribe();
  }

  getAll(){
    this.sbRapportino = this.service.getAll().subscribe( response => {
      this.rapportini = response;
    });
  }

  delete(id: number){
    this.service.delete(id)
    .toPromise()
    .then( ()=>{
      this.ngOnDestroy();
      this.ngOnInit();
    })
    .catch(()=>{
      alert('errore, impossibile cancellare il rapportino');
    });
  }

}
