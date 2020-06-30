import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Rapportino } from '../model/rapportino.model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class RapportinoService {
  apiUrl = 'http://localhost:8080/rapportini';

  constructor(private http: HttpClient) {}

  getAllForIdPersona(id: number): Observable<Rapportino[]> {
    return this.http.get<Rapportino[]>(`${this.apiUrl}/all/${id}`);
  }

  getOne(id: number): Observable<Rapportino> {
    return this.http.get<Rapportino>(`${this.apiUrl}/${id}`);
  }

  delete(id: number) {
    return this.http.delete(`${this.apiUrl}/delete/${id}`);
  }

  addOne(rapportino: Rapportino) {
    return this.http.post(this.apiUrl + '/add', rapportino);
  }

  update(rapportino: Rapportino) {
    return this.http.put(this.apiUrl + '/update', rapportino);
  }
}
