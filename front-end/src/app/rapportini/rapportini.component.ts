import { Component, OnInit } from '@angular/core';
import { Rapportino } from '../model/rapportino.model';
import { Subscription } from 'rxjs';
import { RapportinoService } from '../service/rapportino.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-rapportini',
  templateUrl: './rapportini.component.html',
  styleUrls: ['./rapportini.component.css']
})

export class RapportiniComponent implements OnInit {

  rapportini: Rapportino[];
  sbRapportino: Subscription;
  id: number;
  constructor(private service: RapportinoService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.getAll();
  }

  ngOnDestroy() {
    this.sbRapportino.unsubscribe();
  }

  getAll(){
    this.id= this.route.snapshot.params.id;
    console.log('id: ',this.id);
    this.sbRapportino = this.service.getAllForIdPersona(this.id).subscribe( response => {
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
