import { Timestamp } from "rxjs";
import { Product } from "./product";

export interface User{
    id: string;
    roleType:string;
    firstName:string
    username:string
    email:string
    password:string
    phoneNumber:string
    dateCreated:Timestamp<User>;
    address:string
}