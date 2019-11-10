import { IAccount } from './IAccount';
import { ICard } from './ICard';
import { ILoan } from './ILoan';

export interface IBank {
	id:number;
	bankName:string;
	lastUpdated:Date;
	accounts:Array<IAccount>;
	loans:Array<ILoan>;
	cards:Array<ICard>;
	
	
}