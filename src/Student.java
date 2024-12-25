import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class Student {
    private String name;
    private double gpa;
    private int age;
    private String major;
    public Student(String name, double gpa,int age, String major) {
        this.name = name; this.gpa = gpa;
        this.age = age; this.major = major;
    }
    public String getName() { return this.name; }
    public double getGpa() { return this.gpa; }
    public int getAge() { return this.age; }
    public String getMajor() { return this.major; }
    public void display() {
        System.out.println(this.getName() + "\t" + this.getGpa() +
                "\t" + this.getAge() + "\t" + this.getMajor());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] std = new Student[n];
        for(int i = 0; i < n; i++) {
            System.out.print("\nName : ");
            String name = sc.next();
            System.out.print("\nGPA : ");
            double gpa = sc.nextFloat();
            System.out.print("\nAge : ");
            int age = sc.nextInt();
            System.out.print("\nMajor : ");
            String major = sc.next();
            std[i] = new Student(name,gpa,age,major);
        }
        System.out.println("SortBy : ");
        String attribute = sc.next();
        NameComparator byName = new NameComparator();
        AgeComparator byAge = new AgeComparator();
        GPAComparator byGpa = new GPAComparator();
        MajorComparator byMajor = new MajorComparator();
        switch(attribute) {
            case "age" :
                Arrays.sort(std,byAge);
                break;
            case "name" :
                Arrays.sort(std,byName);
                break;
            case "gpa" :
                Arrays.sort(std,byGpa);
                break;
            case "major" :
                Arrays.sort(std,byMajor);
                break;
        }
        System.out.println("Name\tGPA\tAge\tMajor");
        for(int i = 0; i < n; i++)
            std[i].display();
    }
}
class GPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student one, Student another) {
        if (one.getGpa()< another.getGpa()) return -1;
        else if (one.getGpa() == another.getGpa()) return 0;
        else return +1;
    }
}
class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student one, Student other) {
        return one.getName().compareToIgnoreCase(other.getName());
    }
}
class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student one, Student another) {
        if (one.getAge()< another.getAge()) return -1;
        else if (one.getAge() == another.getAge()) return 0;
        else return +1;
    }
}
class MajorComparator implements Comparator<Student> {
    @Override
    public int compare(Student one, Student other) {
        return one.getMajor().compareToIgnoreCase(other.getMajor());
    }
}
