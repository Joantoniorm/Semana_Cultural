import {Injectable} from "@angular/core";
@Injectable({
  providedIn: 'root'
})
export class MapService{
  public Ubicacion?:[number,number];
  constructor() {
    this.getUbicacion();
  }
  public getUbicacion(){
    navigator.geolocation.getCurrentPosition(
      ({coords})=>{
        this.Ubicacion= [coords.latitude, coords.longitude];
      }
    );
  }
}
