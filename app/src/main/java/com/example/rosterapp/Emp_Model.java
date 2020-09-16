package com.example.rosterapp;

public class Emp_Model {
    private String employee_Name;
    private String employee_Email;
    private String  employee_Phone;




    public Emp_Model(String employee_name, String employee_email, String employee_phone) {
        employee_Name = employee_name;
        employee_Email = employee_email;
        employee_Phone= employee_phone;

    }

    public String getEmployee_Name() {
        return employee_Name;
    }

    public String getEmployee_Email() {
        return employee_Email;
    }
    public String getEmployee_Phone() {
        return employee_Phone;
    }

    public void setEmployee_Name(String employee_Name) {
        this.employee_Name = employee_Name;
    }

    public void setEmployee_Email(String employee_Email) {
        this.employee_Email = employee_Email;
    }
    public void setEmployee_Phone(String employee_Phone) {
        this.employee_Phone = employee_Phone;
    }
}

