import {Component,inject, OnInit} from '@angular/core';
import {Empresa} from "../Empresa";
import {ActivatedRoute} from "@angular/router";
import {EmpresaService} from "../empresa-service";
import {NgOptimizedImage} from "@angular/common";
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-details',
  standalone: true,
  imports: [
    NgOptimizedImage
  ],
  templateUrl: './details.component.html',
  styleUrl: './details.component.css'
})
export class DetailsComponent implements OnInit{
  empresaId: number = 0;
  empresa:Empresa = {idEmpresa:0,nombre:"void",descripcion:"void",imagen_url:"void",altitud:0,latitud:0};
  constructor(public empresaService: EmpresaService, private route: ActivatedRoute) {
  }
  ngOnInit() {
    this.empresaId = this.route.snapshot.params ['id'];
    this.empresaService.find(this.empresaId).subscribe((data:Empresa)=>{
      this.empresa = data;
    })
  }

}
