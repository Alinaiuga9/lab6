package lab7;

public class Student {
    private final String name;
    private final int age;
    private final String address;
    private final String studyGroup;

    public Student(String name, int age, String address, String studyGroup) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.studyGroup = studyGroup;
    }

    public String getNume() {
        return name;
    }

    public int getVarsta() {
        return age;
    }

    public String getAdresa() {
        return address;
    }

    public String getGrupa() {
        return studyGroup;
    }

    public Student moveToGroup(String newGroup) {
        return new Student(this.name, this.age, this.address, newGroup);
    }

    @Override
    public String toString() {
        return "Student{" +
                "nume='" + name + '\'' +
                ", varsta=" + age +
                ", adresa='" + address + '\'' +
                ", grupa='" + studyGroup + '\'' +
                '}';
    }
}