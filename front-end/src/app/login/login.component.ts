import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthappService } from '../service/authapp.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userid = ''
  password = ''
  autenticato = true
  //consentito = false
  errorMsg = 'Spiacente, la userid o la password sono errati!'
  //infoMsg = 'Accesso Consentito'

  constructor(private route : Router, private basicAuth: AuthappService ) { }

  ngOnInit() {
  }

  gestAut() {

    if (this.basicAuth.autentica(this.userid, this.password))
    {
        this.autenticato = true;
        this.route.navigate(['persone']);
    }
    else
    {
        this.autenticato = false;
    }
}
}
