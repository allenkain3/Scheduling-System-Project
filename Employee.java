/*
 * Team 7
 * Name: Kai Nguyen & Masoud Homayouni
 * IT306-001
 * Project: Employee Scheduling System
 * */


package Project306;


public abstract class Employee {

    private String name;
    private String jobTitle;
    private Schedule schedule;


    public Employee(String name, String jobTitle ) {
        this.name = name;
        this.jobTitle = jobTitle;
    }

    /**
     *
     * @return firstName fist name of an employee
     */

    public String getName() {

        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        if ( name == null || name.equals(""))
            throw new IllegalArgumentException("Name can not be empty");
        this.name = name;
    }

    public String getJobTitle(){return jobTitle;}
    public void SetJobTitle(String title){
        this.jobTitle = title;
    }

    public Schedule getSchedule(){return schedule;}
    public void setSchedule(Schedule schedule){
        this.schedule = schedule;
    }


    public abstract double calculatePay();

    /**
     * @return returns a string representation of Employee
     */
    @Override
    public String toString() {
        return "Name: " + this.name + "\nJob Title: " +  this.jobTitle;

    }
    public abstract boolean equals(Object otherObject);

}

