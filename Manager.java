/*
 * Team 7
 * Name: Kai Nguyen & Masoud Homayouni
 * IT306-001
 * Project: Employee Scheduling System
 * */

package Project306;


public class Manager extends Employee {

    private double hour;
    private Schedule schedule;
    // maximum hours a manager can work
    public static final double MAX_HOUR = 40;

    // minimum hours a manager can work
    public static final double MIN_HOUR = 20;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // over time
    public static final double OVER_TIME_RATE = 1.5;
    private double totalHours;

    /**
     * Constructor that initializes Manager object
     */
    public Manager(String name, String jobTitle, String day, String shift) {

        super(name, jobTitle);
        this.schedule = new Schedule(day,shift);

    }

    /**
     *
     * @return hour the manager work hours
     */
    public double getHour() {
        return hour;
    }
//    public static int getNumOfManagers(){return numOfManagers;}

    /**
     *
     * Setting the work hours for Manager
     */
    public void setHour(double hour) {
        if(hour < 1 || hour > 6) {
            throw new IllegalArgumentException("Hours must be between 1 and 6 for each shift\n");
        }
        this.hour = hour;
        totalHours += hour;
    }

    /**
     * Calculating the salary for Manager
     */
    @Override
    public double calculatePay() {

        if ( this.getHour() < MAX_HOUR )

            return this.totalHours * this.getSalary();
        else
            return (this.totalHours - MAX_HOUR ) * (OVER_TIME_RATE * this.getSalary()) + MAX_HOUR * this.getSalary();


    }
    public void setTotal(double hour){
            totalHours += this.hour;

    }

    public Schedule getSchedule(){return schedule;}
    /**
     * @return returns a string representation of manager
     */
    @Override
    public String toString() {
        return super.toString()  + " " +  this.getSchedule().toString() + "\nShift's Hour: " + this.getHour() + "\nRate: $" + this.salary + "\nTotal Worked Hours: " + totalHours;
    }

    /**
     * Equals method to compare Manager objects
     */
    public boolean equals(Object otherObject){
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) return false;

        Manager other = (Manager) otherObject;

        return this.getName().equals(other.getName());
    }

    /**
     * Since we're using HashMap,
     * HashCode method is required when comparing objects
     */
    public int hashCode(){
        if(this.getName() == null){
            return 7;
        }
        return this.getName().hashCode();
    }


}

