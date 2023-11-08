// SPDX-License-Identifier: unlicense
pragma solidity ^0.8.0;

contract bank
{
    int bal;
    constructor(){
        bal=0;
    }

    function getbal() public view returns(int)
    {
        return bal;
    }

    function deposite(int amount) public{
        require(amount>0, "Amount should be greater than 0");
        bal=amount+bal;
    }

    function withdraw(int amount) public 
    {
        require(amount>0, "please deposite more than 0");
        require(amount<=bal, "Insuffficient bal");
        bal=bal-amount;
    }


}