// SPDX-License-Identifier: MIT
pragma solidity ^0.8.16;

enum SKILL {
        DEVELOPER, 
        ARCHITECT,
        QA,
        ANALYST,
        INTERN
}

struct Developer {
        address user;
        string name;
        uint value_day;
        
        bool activeted;
        bool is_working;
        SKILL skill;
    }

contract ManageDev {

    mapping(address => Developer) developers;


    function create(string memory _name , uint _value_day, bool _is_working, SKILL _skill) public {
        require((developers[msg.sender].user == address(0)));
        developers[msg.sender] =  Developer(msg.sender, _name, _value_day, true, _is_working, _skill);
    }

    function update(string memory _name , uint _value_day, bool _is_working, SKILL _skill) public {
        require(!(developers[msg.sender].user == address(0)));
        developers[msg.sender] =  Developer(msg.sender, _name, _value_day, true, _is_working, _skill);
    }

    function get() public view returns(address, string memory, uint, bool, bool, SKILL){
        Developer memory _dev = developers[msg.sender];
        return (_dev.user, _dev.name, _dev.value_day, _dev.activeted, _dev.is_working, _dev.skill);
    }

    function get_by_address(address user) public view returns(address, string memory, uint, bool, bool, SKILL){
        Developer memory _dev = developers[user];
        return (_dev.user, _dev.name, _dev.value_day, _dev.activeted, _dev.is_working, _dev.skill);
    }

    
    function get_dev_value_by_address(address user) public view returns(uint){
        return developers[user].value_day;
    }
    
}