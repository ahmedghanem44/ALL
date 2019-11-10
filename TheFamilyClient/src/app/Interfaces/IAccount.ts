import { IUser } from './iuser';
import { IBank } from './IBank';

export interface IAccount {
	id:number;
	accountName:string;
	accountType:string;
	accountNumber:string;
	accountBalance:number;
	isClosed:Boolean;
	lastUpdated: Date;
	bank: IBank;
	owner: IUser

}