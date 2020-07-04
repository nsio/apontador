import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  chave: String
  
  constructor(
    private route: Router
  ) { }

  ngOnInit(): void {
    
  }

  goCadastro(){
    this.route.navigate(['/cadastro']);
  }

  goPesquisa(){
    this.route.navigate(['/pesquisa'], { queryParams: { chave: this.chave } });
  }

}
