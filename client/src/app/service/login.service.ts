import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) {
  }

  login(loginPayload) {
    const headers = {
      'Authorization': 'Basic ' + btoa('demo_client:password'),
      'Content-type': 'application/x-www-form-urlencoded'
    };
    return this.http.post('http://localhost:7070/oauth/token', loginPayload, {headers});
  }
}
