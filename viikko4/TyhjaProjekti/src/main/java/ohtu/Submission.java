package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Submission {
    private String student_number;
    private int hours;
    private boolean a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12;
    private ArrayList<Boolean> allDone = new ArrayList<Boolean>();
    
    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    
    public void setHours(int hours) {
        this.hours = hours;
    }
    
    public int getHours() {
        return this.hours;
    }
    
    public boolean getA1() {
       return a1;
    }
    public void setAllDone(boolean a) {
        if (allDone.isEmpty()) {
            allDone = new ArrayList<Boolean>();
        }
        if (a) {
            allDone.add(a);
        }
    }
    
    public int getAllDone() {
        setAllDone(getA1());
        setAllDone(a2);
        setAllDone(a3);
        setAllDone(a4);
        setAllDone(a5);
        setAllDone(a6);
        setAllDone(a7);
        setAllDone(a8);
        setAllDone(a9);
        setAllDone(a10);
        setAllDone(a11);
        
        
        return allDone.size();
    }

    @Override
    public String toString() {
        return student_number + " tunnit: " + hours + " - tehtyjen tehtavien lukumaara: " + getAllDone();
    }
    
}