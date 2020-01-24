/*
 * Team 7
 * Name: Kai Nguyen & Masoud Homayouni
 * IT306-001
 * Project: Employee Scheduling System
 * */


package Project306;

public class Associate extends Employee {

    // maximum hours an associate can work
    public static final double MAX_HOUR = 40;
    private Schedule schedule;

    // hours an associate works
    private double hour;
    private static int numOfAssociate;
    private  double totalHours;
    private double salary;


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Constructor that initializes Associate object
     */

    public Associate(String name, String jobTitle, String day, String shift) {
        super(name,jobTitle);
        schedule = new Schedule(day,shift);
        numOfAssociate++;
    }


    /**
     *
     * @return hour the hours an associate works
     */
    public double getHour() {
        return hour;
    }


    /**
     *
     * @param hour
     * @throws throws IllegalArgumentException
     */
    public void setHour(double hour) {
        if (hour < 1 || hour > 6) {
            throw new IllegalArgumentException("Hours must be between 1 and 6 for each shift");
        }
        if(totalHours > MAX_HOUR){
            throw new IllegalArgumentException("Total number of work hours is reached for the week!");
        }
        this.hour = hour;
        totalHours += hour;

    }


    public Schedule getSchedule(){return schedule;}

    public static int getNumOfAssociate() {return numOfAssociate;}

    public void setTotal(double hour){
        if(totalHours < MAX_HOUR){
            totalHours += this.hour;
        }else{
            totalHours = MAX_HOUR;
        }

    }

    /**
     * Calculates salary of the associate
     */
    @Override
    public double calculatePay() {

        return this.totalHours * this.getSalary();
    }

    /**
     * @return returns a string representation of associate
     */

    @Override
    public String toString() {
        return super.toString() + " " + this.getSchedule().toString() + "\nShift's Hour: " + this.getHour() + "\nRate: $" + this.salary + "\nTotal Worked Hours: " + totalHours;
    }

    /**
     * Equals method to compare Manager objects
     */
    public boolean equals(Object otherObject){
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) return false;

        Associate other = (Associate) otherObject;

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


