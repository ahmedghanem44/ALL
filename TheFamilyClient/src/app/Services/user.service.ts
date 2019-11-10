import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { IUser } from '../Interfaces/iuser';
import { IAccount } from '../Interfaces/IAccount';
import { ILoan } from '../Interfaces/ILoan';
import { IIncome } from '../Interfaces/IIncome';
import { ICard } from '../Interfaces/ICard';
import { ILogin } from '../Interfaces/ILogin';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private url = 'http://localhost:8080/api/user';

  constructor(private http: HttpClient, private router: Router) { }

  getAllUsers(): Observable<IUser[]> {
    return this.http.get<IUser[]>(this.url + '/findAll');
  }

  getUserById(id: number): Observable<IUser> {
    return this.http.get<IUser>(this.url + '/find/' + id);
  }

  getUserByUsername(username: string): Observable<IUser> {
    return this.http.get<IUser>(this.url + '//find/username/' + username);
  }

  getUserAccounts(id: number): Observable<IAccount[]> {
    return this.http.get<IAccount[]>(this.url + '/find/' + id + '/accounts');
  }

  getUserLoans(id: number): Observable<ILoan[]> {
    return this.http.get<ILoan[]>(this.url + '/find/' + id + '/loans');
  }

  getUserIncomes(id: number): Observable<IIncome[]> {
    return this.http.get<IIncome[]>(this.url + '/find/' + id + '/incomes');
  }

  getUserCards(id: number): Observable<ICard[]> {
    return this.http.get<ICard[]>(this.url + '/find/' + id + '/cards');
  }

  removeUserById(id: number): string {
    this.http.delete(this.url + '/remove/' + id);
    return 'User has been deleted successfully';
  }

  removeAllUsers(): string {
    this.http.delete(this.url + '/removeAll');
    return 'All Users have been deleted successfully';
  }

  createUser(user:IUser): string{
    this.http.post(this.url + '/add' , user);
    return 'A new user has been created successfully';
  }

  updateUser(user:IUser):string{
    this.http.put(this.url + '/edit' , user);
    return 'User has been updated successfully';
  }

  login(user:ILogin):Observable<ILogin>{
    return this.http.post<ILogin>('http://localhost:8080/login' , user);
   }

}
