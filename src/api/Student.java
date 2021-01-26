package api;

import java.time.LocalDate;
import java.util.ArrayList;


public class Student extends SchoolParticipant{
    private LocalDate dayOfGraduate;
    private ArrayList<Grade> grades = new ArrayList<>();

    public Student(String name, String lastName, int age, LocalDate dayOfGraduate) {
        super(name,lastName,age);
        this.dayOfGraduate = dayOfGraduate;
    }

    public void addGrade(Subject subject, int rating){
        grades.add(new Grade(subject,rating));
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public LocalDate getDayOfGraduate() {
        return dayOfGraduate;
    }

}
