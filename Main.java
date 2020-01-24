/*
* Team 7
* Name: Kai Nguyen & Masoud Homayouni
* IT306-001
* Project: Employee Scheduling System
* */


package Project306;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Map<String, Employee> employees = new HashMap<String, Employee>();
        Schedule s1 = new Schedule();

         String path = "src/Project306/data.txt";
         String path2 = "src/Project306/schedules.txt";

        readfile(path,path2,s1);

        s1.display();

        s1.displayAll();

//        for(String x: employees.keySet()){
//            System.out.println(employees.get(x));
//        }
    }


    /**
     * Reading from data and schedule text files
     * store reference to Employee and Schedule objects
     */
    public static void readfile(String path,String path2,Schedule schedule){
        try{
            String line = null;
            String line2 = null;
            Scanner scan = new Scanner(new FileInputStream(new File(path)));
            Scanner scan2 = null;
            Scanner scan3 = new Scanner(new FileInputStream(new File(path2)));
            Scanner scan4 = null;
            while(scan.hasNextLine() && scan3.hasNextLine()){
                line = scan.nextLine();
                scan2 = new Scanner(line);
                scan2.useDelimiter(",");

                line2 = scan3.nextLine();
                scan4 = new Scanner(line2);
                scan4.useDelimiter(",");

                String name = scan2.next();
                String jobTitle = scan2.next().trim();

                String anotherName = scan4.next();
                String day = scan4.next().trim();
                String shift = scan4.next().trim();

                if(jobTitle.equalsIgnoreCase("Associate")){
                    Employee e = new Associate(name,jobTitle,day,shift);
                    schedule.addSchedule(day, e);
                    addInfo(day,e,schedule,name);
                }else if(jobTitle.equalsIgnoreCase("Manager")){
                    Employee m = new Manager(name,jobTitle,day,shift);
                    schedule.addSchedule(day,m);
                    addInfo(day,m,schedule,name);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * Adding more information to employees
     * They method will validate the employee object to see whether
     * it is Associate or Manager, then prompts additional information
     * such shift's hours and pay rate
     */

    public static void addInfo(String day, Employee e,Schedule schedule,String name){
        Scanner reader = new Scanner(System.in);
        while(true) {
            if (e instanceof Associate) {
                try {
                    System.out.println("Enter shift hours for " + e.getName() + " :");
                    double hour = Double.parseDouble(reader.nextLine());
                    System.out.println("Enter pay: ");
                    double pay = Double.parseDouble(reader.nextLine());
                    if(e.getName().equals(name)){
                        ((Associate) e).setHour(hour);
                        ((Associate)e).setTotal(hour);
                    }else{
                        ((Associate) e).setHour(hour);
                    }
                    ((Associate)e).setSalary(pay);
                    break;
                } catch (NumberFormatException ex) {
                    System.out.println("Hour must be numeric");
                } catch (IllegalArgumentException x) {
                    System.out.println(x.getMessage());
                    continue;
                }
            }
            if (e instanceof Manager) {
                try {
                    System.out.print("Enter shift hours for " + e.getName() + " :");
                    double hour = Double.parseDouble(reader.nextLine());
                    System.out.println("Enter pay:");
                    double pay = Double.parseDouble(reader.nextLine());
                    if(e.getName().equals(name)){
                        ((Manager)e).setHour(hour);
                        ((Manager)e).setTotal(hour);
                    }else{
                        ((Manager) e).setHour(hour);
                    }
                    ((Manager)e).setSalary(pay);
                    break;
                } catch (NumberFormatException ex) {
                    System.out.print("Hour must be numeric");
                } catch (IllegalArgumentException x) {
                    System.out.println(x.getMessage());
                    continue;
                }
            }
        }
    }

}
