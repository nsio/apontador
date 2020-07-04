import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LocalService } from 'src/app/shared/service/local.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  form: FormGroup
  chave: String

  constructor(
    private fb: FormBuilder,
    private localService: LocalService,
    private route: Router
  ) { }

  ngOnInit(): void {
    this.form = this.fb.group({
      descricao: [null,[Validators.required]],
      telefone: [null,[Validators.required]],
      endereco: this.fb.group({
        endereco: [null,[Validators.required]],
        complemento: [null,[Validators.required]],
        bairro: [null,[Validators.required]],
        cidade: [null,[Validators.required]],
        numero: [null,[Validators.required]],
        cep: [null,[Validators.required]]
      })
    });
  }

  onSubmit(){
    if(this.form.valid){
      this.localService.cadastrarLocal(this.form.value).subscribe(
        success => console.log('sucesso'),
        error => console.error(error),
        () => console.log('Request completo')
      );
      this.form.reset();
    }
  }

  goPesquisa(){
    this.route.navigate(['/pesquisa'], { queryParams: { chave: this.chave } });
  }

}