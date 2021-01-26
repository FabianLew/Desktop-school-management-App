package api;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

public class ResourceManager {
    public ArrayList<SchoolParticipant> peopleList = new ArrayList<>();
    private Locale locale;
    protected NumberFormat moneyFormat;

    public ResourceManager(Locale locale) {
        this.locale = locale;

        moneyFormat = NumberFormat.getCurrencyInstance(locale);
    }

    public Student addStudent(String name, String lastName, int age, LocalDate dayOfGraduation){
        Student student =  new Student(name,lastName,age,dayOfGraduation);
        peopleList.add(student);
        return student;
    }

    public Teacher addTeacher(String name, String lastName, int age,Subject mainSubject,int salary){
        Teacher teacher = new Teacher(name,lastName,age,mainSubject,salary);
        peopleList.add(teacher);
        return teacher;
    }

    public void showPeopleList(){
        for(SchoolParticipant pp: peopleList){
            if (pp instanceof Student)
            System.out.println("Student " + pp.getId() + "\n"
                    + "Name: " + pp.getName() + "\n"
                    + "Last name: " + pp.getLastName() + "\n"
                    + "Age: " + pp.getAge() + "\n"
                    + "Date of graduation: " + ((Student) pp).getDayOfGraduate()+ "\n");
            else if(pp instanceof Teacher){
                System.out.println("Teacher " + pp.getId() + "\n"
                        + "Name: " + pp.getName() + "\n"
                        + "Last name: " + pp.getLastName() + "\n"
                        + "Age: " + pp.getAge() + "\n"
                        + "Main Subject: " + ((Teacher) pp).getMainSubject()+ "\n"
                        + "Salary: " + moneyFormat.format(((Teacher) pp).getSalary()) + "\n");
            }
        }
    }

    public void showStudentGrades(Student student){
        for(Grade grade : student.getGrades()){
            System.out.println(grade);
        }
    }

    public void deletePersonByType(SchoolParticipant sp){
        for(Iterator<SchoolParticipant> itr = peopleList.iterator(); itr.hasNext(); ){
            SchoolParticipant schoolParticipant = itr.next();
            if(schoolParticipant.equals(sp)){
                itr.remove();
            }
        }
    }

    public String printPersonInfo(SchoolParticipant schoolParticipant){
        if(schoolParticipant instanceof Student){
            return "Student " + schoolParticipant.getId() + "\n"
                    + "Name: " + schoolParticipant.getName() + "\n"
                    + "Last name: " + schoolParticipant.getLastName() + "\n"
                    + "Age: " + schoolParticipant.getAge() + "\n"
                    + "Date of graduation: " + ((Student) schoolParticipant).getDayOfGraduate()+ "\n";
        }
        else {
            return "Teacher " + schoolParticipant.getId() + "\n"
                    + "Name: " + schoolParticipant.getName() + "\n"
                    + "Last name: " + schoolParticipant.getLastName() + "\n"
                    + "Age: " + schoolParticipant.getAge() + "\n"
                    + "Main Subject: " + ((Teacher) schoolParticipant).getMainSubject()+ "\n"
                    + "Salary: " + moneyFormat.format(((Teacher) schoolParticipant).getSalary()) + "\n";
        }
    }

}
