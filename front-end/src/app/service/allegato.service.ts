import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Allegato } from '../model/allegato.model';

@Injectable({
  providedIn: 'root',
})
export class AllegatoService {
  apiurl = 'http://localhost:8080/allegati';

  constructor(private http: HttpClient) {}

  getAllForIdPersona(id: number): Observable<Allegato[]> {
    return this.http.get<Allegato[]>(`${this.apiurl}/all/${id}`);
  }

  getOne(id: number) {
    return this.http.get<Allegato>(`${this.apiurl}/${id}`);
  }

  deleteOne(id: number) {
    return this.http.delete(`${this.apiurl}/delete/${id}`);
  }

  addOne(newAllegato: Allegato) {
    return this.http.post(this.apiurl + 'add', newAllegato);
  }

  updateOne(editAllegato: Allegato) {
    return this.http.put(this.apiurl + '/update', editAllegato);
  }
}
