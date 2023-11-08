// SPDX-License-Identifier: unlicense
pragma solidity ^0.8.0;

contract studentdata {
    struct student {
        int id;
        string name;
        int age;
    }
    
    student[] students;
    mapping(int => bool) isused;

    event StudentName(string name);

    function addstudent(int id, string memory name, int age) public {
        require(!isused[id], "Id already used");
        student memory newstudent = student(id, name, age);
        students.push(newstudent);
        isused[id] = true;
    }

    function getdetail(uint256 index) public view returns (int, string memory, int) {
        student memory mystudent = students[index];
        return (mystudent.id, mystudent.name, mystudent.age);
    }

    function getcount() public view returns (uint256) {
        return students.length;
    }

    function printStudentNames() public {
        for (uint256 i = 0; i < students.length; i++) {
            emit StudentName(students[i].name);
        }
    }

    fallback() external{
        // Fallback function logic to trigger printing student names
        printStudentNames();
    }
}
