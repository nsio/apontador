import { Component, OnInit } from '@angular/core';
import { LocalService } from 'src/app/shared/service/local.service';
import { Local } from 'src/app/shared/model/local.model';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-pesquisa',
  templateUrl: './pesquisa.component.html',
  styleUrls: ['./pesquisa.component.css']
})
export class PesquisaComponent implements OnInit {

chave: string

  locais: Local[]
  totalItem: number
  config = {
    itemsPerPage: 5,
    currentPage: 0,
    totalItems: this.totalItem
  };
  
  public maxSize: number = 7;
  public directionLinks: boolean = true;
  public autoHide: boolean = false;
  public responsive: boolean = true;
  public labels: any = {
      previousLabel: '<--',
      nextLabel: '-->',
      screenReaderPaginationLabel: 'Pagination',
      screenReaderPageLabel: 'page',
      screenReaderCurrentLabel: `You're on page`
  };

  constructor(
    public localService: LocalService,
    private route: Router,
    private activedRoute: ActivatedRoute
  ) { 
    this.activedRoute.queryParams.subscribe(params =>
      this.chave = params["chave"]
    );
  }

  ngOnInit(): void {
    if(this.chave){
      this.pesquisarLocais(0,this.config.itemsPerPage)
    }
  }

  onChangedPage(event){
    this.config.currentPage = event;
    this.pesquisarLocais(event-1,this.config.itemsPerPage)
  }

  pesquisarLocais(page: number, size: number){
    this.localService
        .pesquisarLocais(this.chave, page, size)
        .subscribe(data => {
          this.locais = data.content;
          this.totalItem = data['totalElements']
          this.config.totalItems = data['totalElements']
        });
  }

  goCadastro(){
    this.route.navigate(['/cadastro']);
  }

}
