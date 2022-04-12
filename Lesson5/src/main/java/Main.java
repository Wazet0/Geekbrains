import Employee.Employee;

public class Main {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Ivanov Ivan","Engineer","ivivan@mailbox.com","892312312",30000,30);
        empArray[1] = new Employee("Vasiliy Petrov", "Programmer", "vasya@gmail.com", "853473094", 56000, 77);
        empArray[2] = new Employee("Mikhail Privetov", "SMM-manager", "privetov@mail.ru", "825938635", 60000, 56);
        empArray[3] = new Employee("Nikita Valuev", "Designer", "nikitaval@gmail.com", "123456789", 50000, 30);
        empArray[4] = new Employee("Vasya Pupkin", "PR-manager", "vspup@mailbox.com", "987654321", 100000, 29);

        for(Employee emp : empArray){
            if(emp.getAge() > 40) {
                emp.printInfo();
                System.out.println("--------------------");
            }
        }
    }
}
