import { IUser } from './iuser';

export interface IRole {
	id:number;
	role:string;
	users:Array<IUser>
}