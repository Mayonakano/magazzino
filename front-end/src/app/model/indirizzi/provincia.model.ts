import { Comune } from './comune.model';

export interface Provincia{
  id?: number;
  provincia: string;
  comuni: Comune[];
}
