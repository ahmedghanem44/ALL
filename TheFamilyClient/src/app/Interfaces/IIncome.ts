import { IUser } from './iuser';

export interface IIncome {
	id:number;
	sourceName:string;
	incomeType:string;
	owner:IUser;
	amount:number;
	dateOfIncome:Date;
	lastUpdated:Date
}