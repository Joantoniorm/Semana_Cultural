import {Component,OnInit} from '@angular/core';
import {Empresa} from "../Empresa";
import * as L from "leaflet";
import {marker} from "leaflet";
import {EmpresaService} from "../empresa-service";
import {MapService} from "../map-service";
import {ReactiveFormsModule} from "@angular/forms";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {CommonModule} from "@angular/common";
import {NgOptimizedImage} from "@angular/common";

@Component({
  selector: 'app-index',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgbModule,
    CommonModule,
    NgOptimizedImage
  ],
  templateUrl: './index.component.html',
  styleUrl: './index.component.css'
})
export class IndexComponent implements OnInit{
  empresas: Empresa[]=[];
  mapa: any;

  constructor(public empresa: EmpresaService) {
  }

  ngOnInit(): void {
    this.empresa.getAll().subscribe((datos:Empresa[])=>{
      this.empresas = datos;
    })
  }
  ngAfterViewInit() {
    setTimeout(() => {
      this.mapa = new L.Map('map').setView([36.736699, -4.553068], 12);

      L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 18,
        minZoom: 10,
      }).addTo(this.mapa);

    for (let empresa of this.empresas){
      marker([empresa.latitud, empresa.altitud]).addTo(this.mapa).bindPopup(`<a href="/details/${empresa.idEmpresa}">${empresa.nombre}</a>`).openPopup();
    }
    },1000);
    }
    }
