package com.company.model;

public class PartTimeStaff extends Staff{
    private int hoursWork;
    public double getSalary(){
        return hoursWork*100;
    }

    public PartTimeStaff(int id, String name,int age,String country, String status, String workingType,int hoursWork) {
        super(id, name,age,country, status, workingType);
        this.hoursWork = hoursWork;
    }

    public int getHoursWork() {
        return hoursWork;
    }

    public void setHoursWork(int hoursWork) {
        this.hoursWork = hoursWork;
    }

    @Override
    public String toString() {
        return String.format("\tID: %1s || Name: %15s || housWork: %4s || Salary: %6s \n",super.getId(),super.getName(),hoursWork,getSalary());

    }
    
}
