import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ResponsePagaeble } from '../model/responsePageable.model';
import { Local } from '../model/local.model';
import { take } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})

export class LocalService {

  apiUrl = 'http://localhost:4000/locais-api/locais';
  httpOtions = {
    headers: new HttpHeaders({
      'Content-Type' : 'application/json'
    }) 
  };

  constructor(
    private httpClient: HttpClient
  ) { }

  public pesquisarLocais(chave: string, page: number, size: number): Observable<ResponsePagaeble> {
    return this.httpClient.get<ResponsePagaeble>(this.apiUrl + '/' + chave + '?page='+page+'&size='+size);
  }

  public cadastrarLocal(local: Local){
    return this.httpClient.post(this.apiUrl, local).pipe(take(1));
  }

}
