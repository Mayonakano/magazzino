import { Persona } from './persona.model';

export interface Rapportino{
  id: number;
  fileRapportino: File;
  dataDiUpload: Date;
  persona: Persona;
}

