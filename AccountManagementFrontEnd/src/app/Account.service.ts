import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';
import { Observable } from 'rxjs';
import { UpdateAddress,UpdateMobileNumber,UpdateName } from './update';


@Injectable({
  providedIn: 'root'
})
export class AccountService {

  _url='http://localhost:8084/account';
  _getUrl='http://localhost:8084/accounts';
  _updateNameUrl='http://localhost:8084/updateName';
  _updateMobileUrl='http://localhost:8084/updateMobile';
  _updateAddressUrl='http://localhost:8084/updateAddress';
  _deleteAccountUrl='http://localhost:8084/account/';
  _findAccountUrl='http://localhost:8084/accounts/';
  _findAccountByNumberUrl='http://localhost:8084/account/';

  constructor(private _http:HttpClient) { }
   
   /**********************************************************************************
	 * Method        addAccount
	 * Description   to add a new account
	 * Created By    Tanushree Verma
	 * Created on    30-July-2020
	 ***********************************************************************************/
  addAccount(user:User):Observable<any>{
    
    return this._http.post<any>(this._url,user);
  }

   /**********************************************************************************
	 * Method        getAccount
	 * Description   to get the details of accounts
	 * Created By    Tanushree Verma
	 * Created on    30-July-2020
	 ***********************************************************************************/
  getAccount():Observable<any>
  {
    return this._http.get<any>(this._getUrl);
  }

   /**********************************************************************************
	 * Method        updateName
	 * Description   to update the account holder name of an existing account
	 * Created By    Tanushree Verma
	 * Created on    30-July-2020
	 ***********************************************************************************/
  updateName(updateName:UpdateName)
  {
    return this._http.post<any>(this._updateNameUrl,updateName);
  }

   /**********************************************************************************
	 * Method        updateMobile
	 * Description   to update the mobile number of an existing account
	 * Created By    Tanushree Verma
	 * Created on    30-July-2020
	 ***********************************************************************************/
  updateMobile(updateMobileNumber:UpdateMobileNumber)
  {
    return this._http.post<any>(this._updateMobileUrl,updateMobileNumber)
  }

   /**********************************************************************************
	 * Method        updateAddress
	 * Description   to update the address of an existing account
	 * Created By    Tanushree Verma
	 * Created on    30-July-2020
	 ***********************************************************************************/
  updateAddress(updateAddress:UpdateAddress)
  {
    return this._http.post<any>(this._updateAddressUrl,updateAddress)
  }

   /**********************************************************************************
	 * Method        deleteAccount
	 * Description   to delete an account
	 * Created By    Tanushree Verma
	 * Created on    30-July-2020
	 ***********************************************************************************/
  deleteAccount(deleteAccount:any)
  {
    return this._http.delete<any>(this._deleteAccountUrl+deleteAccount);
  }

    /**********************************************************************************
	 * Method        findAccount
	 * Description   to check whether account exists or not
	 * Created By    Tanushree Verma
	 * Created on    30-July-2020
	 ***********************************************************************************/
  findAccount(accountNumber:any)
  {
    return this._http.get<any>(this._findAccountUrl+accountNumber);
  }

    /**********************************************************************************
	 * Method        findAccountByAccountNumber
	 * Description   to get details of account whose accoount number is specified
	 * Created By    Tanushree Verma
	 * Created on    30-July-2020
	 ***********************************************************************************/
  findAccountByAccountNumber(acountNumber:any)
  {
    return this._http.get<any>(this._findAccountByNumberUrl+acountNumber);
  }
  
}
