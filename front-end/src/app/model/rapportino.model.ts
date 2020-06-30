import { Persona } from './persona.model';

export interface Rapportino{
  id: number;
  fileRapportino: string;
  dataDiUpload: Date;
  persona: Persona;
}

