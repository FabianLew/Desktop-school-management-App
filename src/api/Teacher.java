package api;

public class Teacher extends SchoolParticipant{
    private Subject mainSubject;
    private int salary;


    public Teacher(String name, String lastName, int age,Subject mainSubject, int salary) {
        super(name, lastName, age);
        this.salary = salary;
        this.mainSubject = mainSubject;
    }

    public Subject getMainSubject() {
        return mainSubject;
    }

    public int getSalary() {
        return salary;
    }
}
