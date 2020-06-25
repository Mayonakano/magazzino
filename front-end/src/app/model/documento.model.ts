import { Persona } from './persona.model';

export interface Documento {

  id?: number;
  tipologia: string;
  fileDocumento: File;
  numeroDocumento: string;
  dataDiScadenzaDocumento: Date;
  persona: Persona;

}


