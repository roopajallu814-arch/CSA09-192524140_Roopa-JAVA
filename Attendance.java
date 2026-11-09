import java.util.*;

class Student {
    int regNo;
    String name;

    Student(int regNo, String name) {
        this.regNo = regNo;
        this.name = name;
    }

    public int hashCode() {
        return Objects.hash(regNo);
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Student))
            return false;

        Student s = (Student) obj;
        return regNo == s.regNo;
    }
}

public class Attendance {
    public static void main(String[] args) {

        HashSet<Student> students = new HashSet<>();

        students.add(new Student(101, "Roopa"));
        students.add(new Student(102, "Priya"));
        students.add(new Student(101, "Roopa"));

        System.out.println("Total Students: " + students.size());

        for (Student s : students) {
            System.out.println(s.regNo + " " + s.name);
        }
    }
}