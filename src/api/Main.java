package api;

import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        ResourceManager resourceManager = new ResourceManager(Locale.US);


        Student student = resourceManager.addStudent("Fabian", "Lewandowski", 18, LocalDate.of(2021,3,21));
        student.addGrade(Subject.MATHS,5);
        student.addGrade(Subject.BIOLOGY,3);
        Teacher teacher = resourceManager.addTeacher("Monika","Kowalska",44,Subject.HISTORY,3300);
        Teacher teacher1 = resourceManager.addTeacher("Piotr","Cebulski",52,Subject.BIOLOGY,3900);


        resourceManager.showPeopleList();
        resourceManager.showStudentGrades(student);
    }
}
