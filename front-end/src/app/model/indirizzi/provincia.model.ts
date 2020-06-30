import { Comune } from './comune.model';
import { Regione } from './regione.model';

export interface Provincia{
  id?: number;
  provincia: string;
  regione: Regione;
}
