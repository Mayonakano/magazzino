import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Documento } from '../model/documento.model';

@Injectable({
  providedIn: 'root'
})

export class DocumentoService {

  apiDs = 'http://localhost:8080/documenti';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Documento[]> {
    return this.http.get<Documento[]>(this.apiDs);
  }

  getOne(id: number){
    return this.http.get<Documento>(`${this.apiDs}/${id}`);
  }

  deleteOne(id: number){
    return this.http.delete(`${this.apiDs}/delete/${id}`);
  }

  addOne(newDc: Documento){
    return this.http.post(this.apiDs + 'add', newDc);
  }

  updateOne(editDc: Documento){
    return this.http.put(this.apiDs + '/update', editDc);
  }


}



