package ohtu;

import java.util.ArrayList;
import java.util.List;


public class Submission {
    private String student_number;
    private String week;
    private Integer hours;
    private Boolean a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21;
    private List<Integer> done;
    private Integer totalTasks;

    public Integer getTotalTasksDone() {
        return done.size();
    }   
    
    public String getStudent_number() {
        return student_number;
    }

    public Integer getHours() {
        return hours;
    }
    
    

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    
    public void taskCounter() throws NoSuchFieldException {
        totalTasks = 0;
        done = new ArrayList<>();
        if (a1 != null) {
            totalTasks++;
            if (a1 == true) {
                done.add(1);
            }
        }        
        
        if (a2 != null) {
            totalTasks++;
            if (a2 == true) {
                done.add(2);
            }
        }        
        
        if (a3 != null) {
            totalTasks++;
            if (a3 == true) {
                done.add(3);
            }
        }        
        
        if (a4 != null) {
            totalTasks++;
            if (a4 == true) {
                done.add(4);
            }
        }        
        
        if (a5 != null) {
            totalTasks++;
            if (a5 == true) {
                done.add(5);
            }
        }        
        
        if (a6 != null) {
            totalTasks++;
            if (a6 == true) {
                done.add(6);
            }
        }        
        
        if (a7 != null) {
            totalTasks++;
            if (a7 == true) {
                done.add(7);
            }
        }        
        
        if (a8 != null) {
            totalTasks++;
            if (a8 == true) {
                done.add(8);
            }
        }        
        
        if (a9 != null) {
            totalTasks++;
            if (a9 == true) {
                done.add(9);
            }
        }        
        
        if (a21 != null) {
            totalTasks++;
            if (a21 == true) {
                done.add(21);
            }
        }        
        
        if (a10 != null) {
            totalTasks++;
            if (a10 == true) {
                done.add(10);
            }
        }        
        
        if (a11 != null) {
            totalTasks++;
            if (a11 == true) {
                done.add(11);
            }
        }        
        
        if (a12 != null) {
            totalTasks++;
            if (a12 == true) {
                done.add(12);
            }
        }        
        
        if (a13 != null) {
            totalTasks++;
            if (a13 == true) {
                done.add(13);
            }
        }        
        
        if (a14 != null) {
            totalTasks++;
            if (a14 == true) {
                done.add(14);
            }
        }        
        
        if (a15 != null) {
            totalTasks++;
            if (a15 == true) {
                done.add(15);
            }
        }        
        
        if (a16 != null) {
            totalTasks++;
            if (a16 == true) {
                done.add(16);
            }
        }        
        
        if (a17 != null) {
            totalTasks++;
            if (a17 == true) {
                done.add(17);
            }
        }        
        
        if (a18 != null) {
            totalTasks++;
            if (a18 == true) {
                done.add(18);
            }
        }        
        
        if (a19 != null) {
            totalTasks++;
            if (a19 == true) {
                done.add(19);
            }
        }        
        
        if (a20 != null) {
            totalTasks++;
            if (a20 == true) {
                done.add(20);
            }
        }
    }

    @Override
    public String toString() {
        String string = "viikko " + week + ": tehtyja tehtavia yhteensa: " + done.size() + " (maksimi "+ totalTasks + "), aikaa kului "
                + hours + " tuntia, tehdyt tehtavat:";
        
        for (Integer task : done) {
            string = string + " " + Integer.toString(task);
        }
        return string;
    }
    
}