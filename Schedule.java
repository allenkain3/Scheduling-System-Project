/*
 * Team 7
 * Name: Kai Nguyen & Masoud Homayouni
 * IT306-001
 * Project: Employee Scheduling System
 * */


package Project306;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Schedule {

    private String day;
    private String shift;

    private Map<String, Set<Employee>> schedules;
    private Map<String, Set<Double>> hours;


    /**
     * Default constructor initializes schedules and hours HashMap
     */
    public Schedule(){
        schedules = new HashMap<String, Set<Employee>>();
        hours = new HashMap<String, Set<Double>>();
    }
    /**
     * Scheduling Employees for each day
     */
    public void addSchedule(String day,Employee employee){
        if(validation(day,employee)){
        if(!schedules.containsKey(day)){
            schedules.put(day, new HashSet<Employee>());
        }
            schedules.get(day).add(employee);
        }
    }
    /**
     * Constructor initializes Schedule object
     */
    public Schedule(String day, String shift) {
        this.day = day;
        this.shift = shift;
    }


    public String getDay(){return day; }
    public void SetDay(String day){
        this.day = day;
    }

    public String getShift(){return shift;}
    public void setShift(String shift){
        this.shift = shift;
    }
    /**
     *
     * calculate total labor cost for a whole week
     */
    public double calculteTotalCost() {
        double total = 0;
        for(String x: schedules.keySet()){
            total += totalCost(x);
        }
        return total;
    }

    /**
     * @return the days on the schedules
     */
    public int getSize(){
        return schedules.size();
    }

    /**
     * Calculating labor cost for each day
     */
    public double totalCost(String day){
        int total =0;
        for(Employee x: schedules.get(day)){
            if(x instanceof Associate){
                total += ((Associate) x).calculatePay();
            }else if(x instanceof Manager){
                total += ((Manager) x).calculatePay();
            }
        }
        return total;
    }

    /**
     * Display all scheduled employees for the whole week
     */
    public void displaySet(String day){
        double total =0;
        if(schedules.containsKey(day)){
            for(Employee x: schedules.get(day)){
                if(x instanceof Associate) {
                    total += ((Associate) x).getHour();
                    System.out.println(x);
                    System.out.println();
                }else if(x instanceof Manager){
                    System.out.println(x);
                    System.out.println();
                }
            }
        }
    }


    /**
     * Validating to make sure Employee cannot work two shift in one day
     */
    public boolean validation(String day, Employee employee) {
        if(schedules.containsKey(day)){
            for(Employee x: schedules.get(day)){
                if(x.getName().equals(employee.getName())){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @return shift status
     */
    public String toString(){
        return "\nShift: " + this.shift;
    }


    /**
     * Display Day of the week along with scheduled employees
     * ex: Monday - Kai.....,
     *            - Kim.....,
     *            - Hannah....
     */
    public void display(){
        for(String x: schedules.keySet()){
            System.out.println("|" + x + " Shift|");
            displaySet(x);
            System.out.println("------------");
        }
    }

    /**
     * Display the total labor cost for the week
     */
    public void displayAll(){
        for(String x: hours.keySet()){
            System.out.println(x + " " + hours.get(x));
//            displayHour(x);
            System.out.println("---------");
        }
        System.out.println("Total Labor of the week: $" + calculteTotalCost());
    }



}

