/*
 * Team 7
 * Name: Kai Nguyen & Masoud Homayouni
 * IT306-001
 * Project: Employee Scheduling System
 * */



package Project306;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Testing {

    /**
     * Pre-populated Data to Employees object
     * then add them to Schedule object
     * test if they are passed/failed
     */
    @Test
    public void insert(){
        Schedule s = new Schedule();
        Employee e1 =  new Associate("Kai","Associate","Sunday","Closing");
        Employee e2 = new Manager("Kim", "Manager","Monday","Opening");
        Employee e3 = new Associate("Hannah", "Associate","Monday","Closing");
        Employee e4 = new Manager("Annah", "Manager","Monday","Closing");
        Employee e5 = new Associate("Kai","Associate","Sunday","Opening");
        Employee e6 = new Manager("Kim", "Manager","Monday","Opening");
        Employee e7 = new Associate("Kai","Associate","Tuesday","Closing");
        Employee e8 = new Associate("Kai","Associate","Wednesday","Closing");

        ((Associate)e1).setHour(6);
        ((Associate)e1).setSalary(10);

        ((Manager)e2).setHour(6);
        ((Manager)e2).setSalary(10);

        ((Associate)e3).setHour(6);
        ((Associate)e3).setSalary(10);

        ((Manager)e4).setHour(6);
        ((Manager)e4).setSalary(10);

        ((Associate)e5).setHour(6);
        ((Associate)e5).setSalary(10);

        ((Manager)e6).setHour(6);
        ((Manager)e6).setSalary(10);

        ((Associate)e7).setHour(6);
        ((Associate)e7).setSalary(10);

        /**
         * Adding Employee to schedules
         */
        s.addSchedule("Sunday", e1);
        s.addSchedule("Monday" ,e2);
        s.addSchedule("Monday", e3);
        s.addSchedule("Monday", e4);
        s.addSchedule("Sunday", e5);
        s.addSchedule("Monday" ,e6);
        s.addSchedule("Tuesday", e7);
        s.addSchedule("Wednesday",e8);

        assertEquals("Expected Days Scheduled: ", 4, s.getSize());
    }
}
