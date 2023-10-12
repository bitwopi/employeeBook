package employeeService;

public class Employee {
    private static int counter = 1;
    private String surname;
    private String name;
    private String patronymic;
    private int id;
    private int department;
    private float salary;

    public Employee(String surname, String name, String patronymic, int department, float salary) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.department = department;
        this.salary = salary;
        this.id = Employee.counter;
        Employee.counter++;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void printFullName() {
        System.out.printf(this.getFullName() + "\n");
    }

    public String getFullName() {
        return String.format("%s %s %s", this.surname, this.name, this.patronymic);
    }

    public String getFullInfo() {
        return String.format("%d.%s department: %d salary: %.2f",
                this.getId(),
                this.getFullName(),
                this.getDepartment(),
                this.getSalary());
    }

    public void printFullInfo(){
        System.out.println(this.getFullInfo());
    }
}
