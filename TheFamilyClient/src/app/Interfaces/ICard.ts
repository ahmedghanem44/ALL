import { IBank } from './IBank';
import { IUser } from './iuser';

export interface ICard {
	id:number;
	creditName:string;
	creditBalance:number;
	creditLimit:number;
	rewardType:string;
	reward:number;
	dueDate:Date;
	closingDate:Date;
	isPaid:Boolean;
	datePaid:Date;
	isClosed:Boolean;
	bank:IBank;
	owner:IUser;
	lastUpdated:Date;	
}