import { from } from 'rxjs'

import { Regione } from './regione.model';

export interface Stato {
  id?: number;
  stato: string;
  regioni: Regione[];
}
