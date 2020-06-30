import { Persona } from './persona.model';

export interface Documento {

  id?: number;
  tipologia: string;
  fileDocumento: string;
  numeroDocumento: string;
  dataDiScadenzaDocumento: Date;
  persona: Persona;

}


