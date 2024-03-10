import {Injectable, setTestabilityGetter} from '@angular/core';
import {HttpClient,HttpHeaders} from "@angular/common/http";
import {Observable, throwError } from 'rxjs';
import {catchError } from 'rxjs/operators';
import {Empresa} from "./Empresa";

@Injectable({
  providedIn:'root'
})
export class EmpresaService{
  private apiUrl = "http://localhost:8080/empresa/";
  httpOptions ={
    headers: new HttpHeaders({
      'Content-type':'application/json'
    })
  };

  constructor(private httClient:HttpClient) {
  }
  getAll(): Observable<Empresa[]>{
    console.log("holis")
    return this.httClient.get<Empresa[]>(this.apiUrl)
      .pipe(catchError(this.errorHandler)
    )
  }
  find (idEmpresa:number):Observable<Empresa>{
    return this.httClient.get<Empresa>(this.apiUrl+idEmpresa).pipe(
      catchError(this.errorHandler)
    )
  }
  errorHandler(error:any){
    let errorMessage ='';

    if (error.error instanceof ErrorEvent){
      errorMessage = error.error.message;
    }else {
      errorMessage = `fallo en empresa_service Código de error: ${error.status}\n Mensaje: ${error.message}`;
    }

    return throwError(()=>errorMessage);
  }
}
