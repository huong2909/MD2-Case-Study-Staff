package com.company.model;

public class PartTimeStaff extends Staff{
    private int hoursWork;
    public double getSalary(){
        return hoursWork*60;
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
        return String.format("\tID: %1s || Tên: %15s || Số giờ: %4s || Tổng lương: %6s \n",super.getId(),super.getName(),hoursWork,getSalary());

    }
    
}
