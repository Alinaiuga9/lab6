package lab7;

public  class Student {
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

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getStudyGroup() {
        return studyGroup;
    }

    public Student moveToGroup(String newGroup) {
        return new Student(this.name, this.age, this.address, newGroup);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", studyGroup='" + studyGroup + '\'' +
                '}';
    }
}