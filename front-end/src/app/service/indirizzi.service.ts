import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Stato } from '../model/indirizzi/stato.model';
import { HttpClient } from '@angular/common/http';
import { Regione } from '../model/indirizzi/regione.model';
import { Provincia } from '../model/indirizzi/provincia.model';
import { Comune } from '../model/indirizzi/comune.model';
import { Indirizzo } from '../model/indirizzi/indirizzo.model';

@Injectable({
  providedIn: 'root',
})
export class IndirizziService {
  private apiStati = 'http://localhost:8080/stati';
  private apiRegioni = 'http://localhost:8080/regioni';
  private apiProvince = 'http://localhost:8080/province';
  private apiComuni = 'http://localhost:8080/comuni';
  private apiIndirizzi = 'http://localhost:8080/indirizzi';

  constructor(private http: HttpClient) {}

  getStati(): Observable<Stato[]> {
    return this.http.get<Stato[]>(this.apiStati);
  }
  getRegioni(): Observable<Regione[]> {
    return this.http.get<Regione[]>(this.apiRegioni);
  }
  getProvince(): Observable<Provincia[]> {
    return this.http.get<Provincia[]>(this.apiProvince);
  }
  getComuni(): Observable<Comune[]> {
    return this.http.get<Comune[]>(this.apiComuni);
  }
  getIndirizzi(): Observable<Indirizzo[]> {
    return this.http.get<Indirizzo[]>(this.apiIndirizzi);
  }
  getOneIndirizzo(id: number): Observable<Indirizzo> {
    return this.http.get<Indirizzo>(`${this.apiIndirizzi}/${id}`);
  }
  addOneIndirizzo(indirizzo: Indirizzo) {
    return this.http.post(this.apiIndirizzi, indirizzo);
  }
  deleteIndirizzo(id: number) {
    return this.http.delete(`${this.apiIndirizzi}/${id}`);
  }
  updateIndirizzo(indirizzo: Indirizzo) {
    return this.http.put(this.apiIndirizzi, indirizzo);
  }
}
