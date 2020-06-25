import { Comune } from './comune.model';

export interface Indirizzo{
  id?: number;
  via: string;
  specificaVia: string;
  cap: number;
  comune: Comune;
}
