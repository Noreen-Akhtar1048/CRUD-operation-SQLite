package com.shahbaz.sqlitecrudeassignment2;

public class employeeClass {
    private String Name,Designation;
    private int ID,Salary,Bonus,Age;
    public employeeClass(){

    }
    public employeeClass(String name, String designation, int ID, int salary, int bonus, int age) {
        Name = name;
        Designation = designation;
        this.ID = ID;
        Salary = salary;
        Bonus = bonus;
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public int getBonus() {
        return Bonus;
    }

    public void setBonus(int bonus) {
        Bonus = bonus;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
