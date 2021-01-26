package api;

public abstract class SchoolParticipant {
    public static int ID = 1;

    private String id;
    private String name;
    private String lastName;
    private int age;

    public SchoolParticipant(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.id = setID();
    }

    private String setID(){
        StringBuilder result = new StringBuilder();
        result.append(this.name.charAt(0)).append("_").append(this.lastName.charAt(0)).append("_").append(String.valueOf(ID));
        ID++;
        return result.toString();
    }

    public String getName() {
        return name;
    }

    protected String getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    protected int getAge() {
        return age;
    }
}
