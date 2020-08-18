import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { AccountService } from '../Account.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

  error={
    data:''
  }

  userAccount={
    accountHolderName:''
  }

  isDisabled=true;
  isPresent=false;
 
  constructor(private router:Router,private _deleteService:AccountService) { }

  ngOnInit(): void {
  }

  
  /**********************************************************************************
	 * Method        goHome 
	 * Description   for going back to the homepage
	 * Created By    Tanushree Verma
	 * Created on    29-July-2020
	 ***********************************************************************************/
  goHome()
  {
    this.router.navigate(['']);
  }

    /**********************************************************************************
	 * Method        find 
	 * Description   checks whether the account exists or not
	 * Created By    Tanushree Verma
	 * Created on    29-July-2020
	 ***********************************************************************************/
  find(value:any)
  {
    if(value.length>=10)
    {
      this._deleteService.findAccount(value).subscribe(
        result=>{
        this.getAccountByAccountNumber(value);
        this.error=result;
        console.log(this.error);
        if(result.data=='')
        {
          this.isDisabled=false; 
          this.isPresent=true; 
        }
        else
        {
          this.isDisabled=true;
          this.isPresent=false;
          this.userAccount.accountHolderName='';
        }
      });
    }
    else{
      this.isPresent=false;
    }
  }

    /**********************************************************************************
	 * Method        deleteAccount
	 * Description   deleting an account associated with the account number provided
	 * Created By    Tanushree Verma
	 * Created on    29-July-2020
	 ***********************************************************************************/

  deleteAccount(accountNumber:any)
  {
    this._deleteService.deleteAccount(accountNumber)
    .subscribe(
      response=>{
        alert(response.data);
        if(response.data=="Account deleted Sucessfully")
        {
        this.goHome();
        }
        
      }
    );
  }

  /**********************************************************************************
	 * Method        getAccountByAccountNumber 
	 * Description   for getting the details of account by account number
	 * Created By    Tanushree Verma
	 * Created on    29-July-2020
	 ***********************************************************************************/

  getAccountByAccountNumber(value:any)
  {
    this._deleteService.findAccountByAccountNumber(value).subscribe(
      result=>{
        this.userAccount.accountHolderName=result.accountHolderName;
        console.log(this.userAccount)
        console.log(result);
      }
    )
  }
}
