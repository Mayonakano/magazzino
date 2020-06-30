import { Persona } from './persona.model';

export interface Allegato {
  id?: number;
  nomeAllegato: string;
  allegato: File;
  dataDiUpload: Date;
  persona: Persona;
}
