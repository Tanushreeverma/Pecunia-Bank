export class User {

    constructor(
        public customerFirstName:string,
        public customerLastName:string,
        public dob:string,
        public age:string,
        public gender:string,
        public contactNumber:string,
        public panNumber:string,
        public adhaarNumber:string,
        public accountType:string,
        public openingBalance:number,
        public address:Address,
        public branchId:string,
        public creditScore:number
    ){}
}
export class Address{
    constructor(
        public street:string,
        public city:string,
        public state:string,
        public zipCode:string
    ){}
}
