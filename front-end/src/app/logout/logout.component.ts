import { Component, OnInit } from '@angular/core';
import { AuthappService } from '../service/authapp.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private basicAuth: AuthappService) { }

  ngOnInit(){
   this.basicAuth.clearAll();
  }

}
