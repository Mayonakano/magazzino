import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Persona } from '../model/persona.model';

export class PersonaService{

@Injectable({
  providedIn: 'root'
})

apiPs = "http://localhost:8080/persona"

constructor(private http: HttpClient){}

getAll(): Observable<Persona[]>{
    return this.http.get<Persona[]>(this.apiPs);
}

getOne(id: number){
  return this.http.get<Persona>(`${this.apiPs}/${id}`);//
}

delete(id: number){
  return this.http.delete(`${this.apiPs}/delete/${id}`);
}

addOne(persona: Persona){
  return this.http.post(`${this.apiPs}/add`,persona);
}

updateOne(persona: Persona){
  return this.http.put(`${this.apiPs}/update`, persona);
}

}
