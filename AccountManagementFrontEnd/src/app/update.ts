import { Address } from './user';

export class UpdateName{
    constructor(
        public accountNumber:number,
        public firstName:string,
        public lastName:string){}
}
export class UpdateMobileNumber{
    constructor(
        public mobileNumber:String,
        public accountNumber:number){}
}
export class UpdateAddress{
    constructor(
        public accountNumber:number,
        public address:Address){}
    
}
