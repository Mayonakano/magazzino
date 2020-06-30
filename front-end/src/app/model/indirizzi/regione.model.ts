import { Provincia } from './provincia.model';
import { Stato } from './stato.model';

export interface Regione{
  id?: number;
  regione: string;
  stato: Stato;
}
