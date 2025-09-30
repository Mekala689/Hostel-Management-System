import java.util.*;

abstract class Person {
    String name;
    String contact;

    Person(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    abstract void showDetails();
}

class Student extends Person {
    int rollNo;
    String room;
    double feesPaid;

    Student(int rollNo, String name, String contact, String room) {
        super(name, contact);
        this.rollNo = rollNo;
        this.room = room;
        this.feesPaid = 0; 
    }

    
    void showDetails() {
        System.out.println("Student: " + rollNo + " | " + name + " | Room: " + room + " | Fees Paid: " + feesPaid);
    }

    void payFees(double amt) {
        feesPaid += amt;
    }

    double getDues() {
        return 5000 - feesPaid; 
    }
}

class Warden extends Person {
    String staffId;

    Warden(String staffId, String name, String contact) {
        super(name, contact);
        this.staffId = staffId;
    }
    void showDetails() {
        System.out.println("Warden: " + staffId + " | " + name);
    }
}


public class HostelDemo {
    public static void main(String[] args) {
    
        Warden w = new Warden("W001", "Mr. Kumar", "9876543210");
        w.showDetails();
        System.out.println("---------------------------");

    
        Student s1 = new Student(101, "Ravi", "9999999999", "A101");
        Student s2 = new Student(102, "Anita", "8888888888", "A102");
        Student s3 = new Student(103, "Karthik", "7777777777", "A103");

        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        System.out.println("All Students:");
        for (Student s : students) {
            s.showDetails();
        }
        System.out.println("---------------------------");

        s1.payFees(2000);
        s2.payFees(5000);
        s3.payFees(3000);
    
        System.out.println("Check Dues:");
        for (Student s : students) {
            System.out.println("Student: " + s.name + " | Dues: " + s.getDues());
        }
        System.out.println("---------------------------");

        int searchRoll = 102;
        System.out.println("Searching for student with roll no " + searchRoll + ":");
        for (Student s : students) {
            if (s.rollNo == searchRoll) {
                s.showDetails();
            }
        }
    }
}