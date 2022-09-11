// SPDX-License-Identifier: MIT
pragma solidity ^0.8.16;

import "./ManageDev.sol";
import {Developer} from "./ManageDev.sol";

contract ContractDev {
    

    mapping(address => uint) total_costs;
    mapping(address => mapping(address => Developer)) developers;


    function new_contract(address _developer) public {
        require(!(_developer == address(0)));

        (address _user, string memory _name , uint _value_day, bool _activeted, bool _is_working, SKILL _skill) = ManageDev(0x67d269191c92Caf3cD7723F116c85e6E9bf55933).get_by_address(_developer);
        Developer memory _new_dev = Developer(_user, _name, _value_day, _activeted, _is_working, _skill);
        

        total_costs[msg.sender] = total_costs[msg.sender] + _value_day;
        developers[msg.sender][_developer] = _new_dev;
    }
    

    function is_developer_contracted(address _developer) public view returns(bool){
        if (!(developers[msg.sender][_developer].user == address(0))){
            return true;
        }        
        return false;
    }

    function get_total_cost() public view returns(uint){
        return total_costs[msg.sender];
    }

   
}