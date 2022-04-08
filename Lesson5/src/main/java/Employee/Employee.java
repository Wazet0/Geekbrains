package Employee;

public class Employee {
    private String name;
    private String profession;
    private String email;
    private String phoneNumber;
    private int profit;
    private int age;

    public Employee(String name, String profession, String email, String phoneNumber, int profit, int age){
        this.name = name;
        this.profession = profession;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.profit = profit;
        this.age = age;
    }

    public void printInfo(){
        System.out.printf("Name: %s\nProffesion: %s\nEmail: %s\nPhone number: %s\nProfit: %d\nAge: %d\n",
                this.name, this.profession, this.email, this.phoneNumber, this.profit, this.age);
    }

    public int getAge() {
        return age;
    }
}
