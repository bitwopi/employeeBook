package employeeService;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBook {
    private List<Employee> employeeList;


    public EmployeeBook(){
        this.employeeList = new ArrayList<>();
    }

    public EmployeeBook(List<Employee> employeeList) {
        if(employeeList != null)
            this.employeeList = employeeList;
        else
            this.employeeList = new ArrayList<>();
    }
    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        this.employeeList.remove(id);
    }

    public Employee getEmployeeByFullName(String surname, String name, String patronymic) {
        for (Employee employee : this.employeeList) {
            if(employee.getSurname().equals(surname)
                    & employee.getName().equals(name)
                    & employee.getPatronymic().equals(patronymic))
                return employee;
        }
        return null;
    }

    public void editEmployee(String surname, String name, String patronymic, int department, float salary) {
        Employee employee = this.getEmployeeByFullName(surname, name, patronymic);
        employee.setSalary(salary);
        employee.setDepartment(department);
    }

    public void printDepartments() {
        for(int i = 1; i<=5; i++){
            System.out.println("Department №" + i);
            for (Employee employee : this.employeeList) {
                if (employee.getDepartment() == i)
                    System.out.printf("\t%d. %s salary: %.2f\n",
                            employee.getId(),
                            employee.getFullName(),
                            employee.getSalary());
            }
        }
    }

    public void printFullNameList() {
        System.out.println("All employees names:");
        for (Employee employee : this.employeeList)
            employee.printFullName();
    }

    public void printEmployeesInfo() {
        System.out.println("Information about all employees:");
        for (Employee employee : this.employeeList) {
            employee.printFullInfo();
        }
    }

    public float calculateSumOfSalaries() {
        float sum = 0;
        for (Employee employee : this.employeeList)
            sum += employee.getSalary();
        return sum;
    }

    public float calculateAverageOfSalary() {
        return calculateSumOfSalaries() / this.employeeList.size();
    }

    public Employee getEmployeeWithMinSalary() {
        Employee min = this.employeeList.get(0);
        for (Employee employee : this.employeeList) {
            if (employee.getSalary() < min.getSalary())
                min = employee;
        }
        return min;
    }

    public Employee getEmployeeWithMaxSalary() {
        Employee max = this.employeeList.get(0);
        for (Employee employee : this.employeeList) {
            if (employee.getSalary() > max.getSalary())
                max = employee;
        }
        return max;
    }

    public void indexSalaries(float percent) {
        for (Employee employee : this.employeeList)
            employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
    }

    public Employee getFirstEmployeeInDepartment(int department) {
        for (Employee employee : this.employeeList)
            if (employee.getDepartment() == department) return employee;
        return null;
    }

    public Employee getEmployeeWithMinSalaryInDepartment(int department) {
        Employee min = getFirstEmployeeInDepartment(department);
        if (min != null) {
            for (Employee employee : this.employeeList) {
                if (employee.getDepartment() == department && employee.getSalary() < min.getSalary())
                    min = employee;
            }
        }
        return min;
    }

    public Employee getEmployeeWithMaxSalaryInDepartment(int department) {
        Employee max = getFirstEmployeeInDepartment(department);
        if (max != null) {
            for (Employee employee : this.employeeList) {
                if (employee.getDepartment() == department && employee.getSalary() > max.getSalary())
                    max = employee;
            }
        }
        return max;
    }

    public float getAverageSalariesInDepartment(int department) {
        int counter = 0;
        float avg = 0;
        for (Employee employee : this.employeeList) {
            if (employee.getDepartment() == department) {
                avg += employee.getSalary();
                counter++;
            }
        }
        if (counter == 0) return 0;

        return avg / counter;
    }

    public void indexSalaryInDepartment(int department, float percent) {
        for (Employee employee : this.employeeList) {
            if (employee.getDepartment() == department)
                employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
        }
    }

    public void printAllEmployeesInDepartment(int department) {
        for (Employee employee : this.employeeList) {
            if (employee.getDepartment() == department)
                System.out.println(employee.getFullName() + "salary: " + employee.getSalary());
        }
    }

    public void findEmployeesBySalaryMore(float salary) {
        for (Employee employee : this.employeeList) {
            System.out.println("Employees with salary more than " + salary + ":");
            if (employee.getSalary() >= salary)
                employee.printFullInfo();
        }
    }

    public void findEmployeesBySalaryLess(float salary) {
        for (Employee employee : this.employeeList) {
            System.out.println("Employees with salary less than " + salary + ":");
            if (employee.getSalary() <= salary)
                employee.printFullInfo();
        }
    }
}
