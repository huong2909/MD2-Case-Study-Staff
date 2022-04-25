package com.company.model;

public class FullTimeStaff extends Staff{
    private int bonus;
    private int dayOff;
    private int  hardSalary;


    public FullTimeStaff(int id, String name, int age, String country, String status, String workingType, int bonus, int dayOff, int hardSalary) {
        super(id, name, age, country, status, workingType);
        this.bonus = bonus;
        this.dayOff = dayOff;
        this.hardSalary = hardSalary;
    }
    public double getSalary(){
        return hardSalary+(bonus-(dayOff*300));
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getFine() {
        return dayOff;
    }

    public void setFine(int fine) {
        this.dayOff = fine;
    }

    public int getHardSalary() {
        return hardSalary;
    }

    public void setHardSalary(int hardSalary) {
        this.hardSalary = hardSalary;
    }

    @Override
    public String toString() {
        return String.format("\tID: %1s || Tên: %15s || Thưởng: %4s || Phạt: %4s || Lương cứng: %6s || Tổng lương: %6s \n",super.getId(),super.getName(),bonus,dayOff*300,hardSalary,getSalary());

    }
}
