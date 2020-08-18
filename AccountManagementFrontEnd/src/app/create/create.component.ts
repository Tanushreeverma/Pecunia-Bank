import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from '../user';
import { Address } from '../user';
import { AccountService } from '../Account.service';


@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  userModel=new User('','','','','','','','','',null,new Address('','','',''),'',null);  
  
  data=[];
  dataPan=[];
  isPresent=false;
  isPanPresent=false;
  constructor(private router:Router,private _createService:AccountService) { }
  
  ngOnInit() {
  }

  

  onSubmit(){
    this._createService.addAccount(this.userModel)
    .subscribe((result:any)=>{
      alert(result.data);
      this.goHome()});
 
  }

    /**********************************************************************************
	 * Method        goHome
	 * Description   for going back to the home page
	 * Created By    Tanushree Verma
	 * Created on    29-July-2020
	 ***********************************************************************************/

   goHome(){
     
     this.router.navigate(['']);
   }

     /**********************************************************************************
	 * Method        getAge 
	 * Description   to calculate age with the help of dob provided
	 * Created By    Tanushree Verma
	 * Created on    29-July-2020
	 ***********************************************************************************/

  getAge(value:any){

    this.userModel.age='';
    let currentYear: any = new Date().getFullYear(); //2020
    let userBirthYear: any = new Date(value).getFullYear();
    let age = currentYear - userBirthYear
    if(age>=0)
    {
      this.userModel.age = age.toString();
    }
  }

    /**********************************************************************************
	 * Method        checkAdhaar 
	 * Description   checks whether the adhaar number mentioned already exists or not
	 * Created By    Tanushree Verma
	 * Created on    29-July-2020
	 ***********************************************************************************/

  checkAdhaar(value)
  {
    if(value.length==11)
    {
      
      this.isPresent=false;
    }
    else if(value.length==10)
    {
      this.data=[];
    }
    else if(value.length==12)
    {
      this.find();
      this.data.forEach((element,index,array)=>{
        if(element==value)
        {
          this.isPresent=true;
        }
      }) 
    }
    else
    {
      this.isPresent=false;

    }
  }

   /**********************************************************************************
	 * Method        checkPan
	 * Description   checks whether the pan number mentioned already exists or not
	 * Created By    Tanushree Verma
	 * Created on    29-July-2020
	 ***********************************************************************************/

  checkPan(value)
  {
    if(value.length==9)
    {
      this.isPanPresent=false;
    }
    else if(value.length==8)
    {
      this.dataPan=[];
    }
    else if(value.length==10)
    {
      this.find();
      this.dataPan.forEach((element,index,array)=>{
        if(element==value)
        {
          this.isPanPresent=true;
        }
      })
    }
    else
    {
      this.isPanPresent=false;
    }

  }
  
   /**********************************************************************************
	 * Method        find
	 * Description   to find the list of adhaar numbers and pan numbers
	 * Created By    Tanushree Verma
	 * Created on    29-July-2020
	 ***********************************************************************************/

  find()
  {
    this._createService.getAccount().subscribe(
      response=>{
        for(let r of response)
        {
          this.data.push(r.customerDetails.adhaarNumber);  
          this.dataPan.push(r.customerDetails.panNumber)  
        }
        
      });
  }
}