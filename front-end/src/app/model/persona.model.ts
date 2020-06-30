import { Indirizzo } from './indirizzi/indirizzo.model';

export interface Persona {
  id?: number;
  nome: string;
  cognome: string;
  dataDiNascita: Date;
  codiceFiscale: string;
  password: string;
  foto: string;
  email: string;
  categoriaProtetta: boolean;
  residenza: Indirizzo;
  domicilio: Indirizzo;
}
