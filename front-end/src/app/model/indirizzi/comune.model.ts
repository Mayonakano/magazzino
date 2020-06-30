import { Provincia } from './provincia.model';

export interface Comune{
  id?: number;
  comune: string;
  provincia: Provincia;
}
