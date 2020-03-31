import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../model/customer";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  baseUrl: string = 'http://localhost:8080/api/v1/customers';

  constructor(private http: HttpClient) {
  }

  public findAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.baseUrl + '?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token);
  }

  public save(customer: Customer) {
    return this.http.post<Customer>(this.baseUrl + '?access_token=' + JSON.parse(window.sessionStorage.getItem('token')).access_token, customer);
  }

}
