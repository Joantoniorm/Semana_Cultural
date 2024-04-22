import {Component,inject, OnInit} from '@angular/core';
import {Empresa} from "../Empresa";
import {ActivatedRoute} from "@angular/router";
import {EmpresaService} from "../empresa-service";
import {NgOptimizedImage} from "@angular/common";
import * as L from "leaflet";
import {marker} from "leaflet";
import {MapService} from "../map-service";
import { CommonModule } from '@angular/common';
import {ReactiveFormsModule} from "@angular/forms";
@Component({
  selector: 'app-details',
  standalone: true,
  imports: [
    NgOptimizedImage,
    ReactiveFormsModule
  ],
  templateUrl: './details.component.html',
  styleUrl: './details.component.css'
})
export class DetailsComponent implements OnInit{
  empresaId: number = 0;
  empresa:Empresa = {idEmpresa:0,nombre:"void",descripcion:"void",imagen_url:"void",altitud:0,latitud:0};
  mapa: any;
  constructor(public empresaService: EmpresaService, private route: ActivatedRoute) {
  }
  ngOnInit() {
    this.empresaId = this.route.snapshot.params ['id'];
    this.empresaService.find(this.empresaId).subscribe((data:Empresa)=>{
      this.empresa = data;
    })
  }
  ngAfterViewInit() {
    setTimeout(() => {
      this.mapa = new L.Map('map').setView([this.empresa.latitud, this.empresa.altitud], 16);

      L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 18,
        minZoom: 10,
      }).addTo(this.mapa);
        marker([this.empresa.latitud, this.empresa.altitud]).addTo(this.mapa).bindPopup(`<a href="/details/${this.empresa.idEmpresa}">${this.empresa.nombre}</a>`).openPopup();
    },1000);
  }
}
