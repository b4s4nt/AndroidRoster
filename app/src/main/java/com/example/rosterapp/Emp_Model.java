package com.example.rosterapp;

public class Emp_Model {
    private String employee_Name;
    private String employee_Email;

    public Emp_Model(String employee_name, String employee_email) {
        employee_Name = employee_name;
        employee_Email = employee_email;
    }

    public String getEmployee_Name() {
        return employee_Name;
    }

    public String getEmployee_Email() {
        return employee_Email;
    }

    public void setEmployee_Name(String employee_Name) {
        this.employee_Name = employee_Name;
    }

    public void setEmployee_Email(String employee_Email) {
        this.employee_Email = employee_Email;
    }
}

