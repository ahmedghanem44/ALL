import { IBank } from './IBank';
import { IUser } from './iuser';

export interface ILoan {
	id:number;
	loanName:string;
	loanBalance:number;
	monthlyPayment:number;
	dueDate:Date;
	isPaid:Boolean;
	bank:IBank;
	owner:IUser;
	isClosed:Boolean;
	lastUpdated:Date

}