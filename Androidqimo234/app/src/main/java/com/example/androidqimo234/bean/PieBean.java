package com.example.androidqimo234.bean;

public class PieBean {
    private String salaries;
    private int percentage;//工资占比情况

    public PieBean(String salaries, int percentage) {
        this.salaries = salaries;
        this.percentage = percentage;
    }

    public String getSalaries() {
        return salaries;
    }

    public void setSalaries(String salaries) {
        this.salaries = salaries;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }
}
