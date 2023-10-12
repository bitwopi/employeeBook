import employeeService.Employee;
import employeeService.EmployeeBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employeeList =  new ArrayList<>(Arrays.asList(
                new Employee("Жмышнко", "Валерий", "Альбертович", 1, 50000),
                new Employee("Цой", "Виктор", "Робертович", 2, 100000),
                new Employee("Пай", "Девочка", "Михайловна", 2, 100000),
                new Employee("Юсим", "Матвей", "Александрович", 5, 500000)));
        EmployeeBook book = new EmployeeBook(employeeList);
        book.printEmployeesInfo();
        book.getEmployeeWithMinSalary().printFullName();
        book.getEmployeeWithMaxSalary().printFullName();
        System.out.println(book.calculateAverageOfSalary());
        book.printFullNameList();
        book.printDepartments();
        book.addEmployee(new Employee("Белогай", "Дмитрий", "Владимирович", 4, 60000));
        book.editEmployee("Юсим", "Матвей", "Александрович", 5, 1000000);
        book.printEmployeesInfo();
        book.printDepartments();
    }
}