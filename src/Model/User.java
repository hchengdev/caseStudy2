package Model;

public class User {
    private String name;
    private int age;
    private double idCardNumber;

    public User(String name, int age, double idCardNumber) {
        this.name = name;
        this.age = age;
        this.idCardNumber = idCardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(double idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", IdCardNumber=" + idCardNumber +
                '}';
    }
}
