import { IAccount } from './IAccount';
import { IIncome } from './IIncome';
import { ICard } from './ICard';
import { ILoan } from './ILoan';
import { IRole } from './IRole';

export interface IUser {
	userId: number;
	firstName: string;
	lastName: string;
	phone: string;
	userName: string;
	userPassword: string;
	email: string;
	lastUpdated: Date;
	role:Array<IRole>;
	accounts: Array<IAccount>;
	incomes: Array<IIncome>;
	cards: Array<ICard>;
	loans: Array<ILoan>

}