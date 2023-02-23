package com.labcorp.demo.model;

public abstract class Employee {
	private String name;
	private long id;
    private float vacationDays;
    private float vacationsPerYear;
    private final float yearly_working_days = 260;
    private int totalDaysWorked;
    private static int empCounter=1;

    public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getTotalDaysWorked() {
		return totalDaysWorked;
	}


	public void setTotalDaysWorked(int totalDaysWorked) {
		this.totalDaysWorked = totalDaysWorked;
	}


	public Employee(String name) {
    	this.name = name;
    	this.id = empCounter++;
    	String className = this.getClass().getSimpleName();
        if (className.equals("HourlyEmployee")) {
            this.vacationDays = 10.0f;
            this.vacationsPerYear = 10.0f;
        } else if (className.equals("SalariedEmployee")) {
            this.vacationDays = 15.0f;
            this.vacationsPerYear =15.0f;
        } else if (className.equals("Manager")) {
            this.vacationDays = 30.0f;
            this.vacationsPerYear = 30.0f;
        } 
    }
    

    public float getVacationDays() {
        return vacationDays;
    }

    protected void setVacationDays(float vacationDays) {
        if (vacationDays < 0.0f) {
            throw new IllegalArgumentException("Vacation days cannot be negative");
        }
        this.vacationDays = vacationDays;
    }
    
    public void work(int daysWorked) {
        if (daysWorked < 0 || daysWorked > 260) {
            throw new IllegalArgumentException("Invalid number of days worked: " + daysWorked);
        }
        vacationDays += daysWorked * vacationsPerYear/yearly_working_days;
    }
    
    public void takeVacation(float vacationDaysTaking) {
    	if(vacationDaysTaking > vacationDays) {
    		throw new IllegalArgumentException(String.format("Cann't take more vacations {} then available {} ", vacationDaysTaking,vacationDays));
    	} else if(vacationDaysTaking < 0) {
    		throw new IllegalArgumentException("Vacacations Can not be negative");
    	}
    	
    	vacationDays-=vacationsPerYear;
    }


	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", vacationDays=" + vacationDays + ", totalDaysWorked="
				+ totalDaysWorked + "]";
	}
    
    

}
