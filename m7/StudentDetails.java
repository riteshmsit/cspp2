import java.util.*;
class StudentDetails {
    String name,rollnumber;
    double grade1,grade2,grade3;
    public StudentDetails(String name,String rollnumber,double grade1,
        double grade2,double grade3) {
        this.name = name;
        this.rollnumber = rollnumber;
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }
    public void gpa() {
        System.out.printf("%.1f",((grade1 + grade2 + grade3)/3));
        System.out.println();
    }
}
class Student {
    public static void main(String[] args) {
    StudentDetails d1 = new StudentDetails("Sangay", "IT201985001", 7.5, 7.0, 8.0);
    d1.gpa();
    StudentDetails d2 = new StudentDetails("Bidhya", "IT201985003", 8.5, 6.0, 7.5);
    d2.gpa();
    StudentDetails d3 = new StudentDetails("Kelzang", "IT201985065", 7.5, 8.0, 9.0);
    d3.gpa(); 
    }
}   
