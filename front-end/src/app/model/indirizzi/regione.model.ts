import { Provincia } from './provincia.model';

export interface Regione{
  id?: number;
  regione: string;
  province: Provincia[];
}
