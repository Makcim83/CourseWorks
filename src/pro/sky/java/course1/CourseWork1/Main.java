package pro.sky.java.course1.CourseWork1;

import java.util.ArrayList;

public class Main {
    public static Employee EmployeeBook[] = new Employee[10];
    public static void main(String[] args) {
        EmployeeBook[0] = new Employee("Иванов", "Иван", "Иванович", 1, 30000);
        EmployeeBook[1] = new Employee("Петров", "Иван", "Степаный", 2, 40000);
        EmployeeBook[2] = new Employee("Сидоров", "Иван", "Фомиич", 3, 50000);
        EmployeeBook[3] = new Employee("Кузнецов", "Иван", "Кузмич", 1, 60000);
        EmployeeBook[6] = new Employee("Романов", "Роман", "Сергеевич", 5, 70000);

        int departmentNumber;
        ArrayList<Employee> departmentEmployeeList = new ArrayList<>();
        double indexationRatio = 0.05;
        int divisionBySalary = 55000;

        // Базовая сложость. методы по всем сотрудникам
        System.out.println("Список всех сотрудников");
        allEmployeeToPrint(EmployeeBook);
        System.out.println("Сумма затрат на зарплату " + amountSalaryOfAllEmployeers(EmployeeBook));
        System.out.println("Сотрудник с минимальной зарплатой " + minimalSalaryEmployee(EmployeeBook).toStringFullName());
        System.out.println("Сотрудник с максимальной зарплатой " + maximumSalaryEmployee(EmployeeBook).toStringFullName());
        System.out.println("Среднее значение зарплат " + amountSalaryOfAllEmployeers(EmployeeBook) / numEmployeers(EmployeeBook));

        // Продвнутая сложность. методы для сотрудников одого отдела
        departmentNumber = 1;
        System.out.println("\nДанные по сотрудникам отдела № " + departmentNumber);
        for (Employee de : EmployeeBook
             ) {
            if (de != null){
                if (de.getDepartmentNumber() == departmentNumber){
                    departmentEmployeeList.add(de);
                }
            }
        }
        allEmployeeToPrint(departmentEmployeeList.toArray(new Employee[0]));
        System.out.println("Сумма затрат на зарплату " + amountSalaryOfAllEmployeers(departmentEmployeeList.toArray(new Employee[0])));
        System.out.println("Сотрудник с минимальной зарплатой " + minimalSalaryEmployee(departmentEmployeeList.toArray(new Employee[0])).toStringFullName());
        System.out.println("Сотрудник с максимальной зарплатой " + maximumSalaryEmployee(departmentEmployeeList.toArray(new Employee[0])).toStringFullName());
        System.out.println("Среднее значение зарплат " + amountSalaryOfAllEmployeers(departmentEmployeeList.toArray(new Employee[0])) / numEmployeers(departmentEmployeeList.toArray(new Employee[0])));

        System.out.println("\nПроведем индексацию зарплат всех сотрудников на коэффициент индексации " + indexationRatio);
        System.out.println("Сумма затрат на зарплату до индексации " + amountSalaryOfAllEmployeers(EmployeeBook));
        salaryIndexation(indexationRatio, EmployeeBook);
        System.out.println("Сумма затрат на зарплату после индексации " + amountSalaryOfAllEmployeers(EmployeeBook));

        System.out.println("\nПоказать всех сотрудников с зарплатами выше " + divisionBySalary);
        showEmployeeWithHighSalary(divisionBySalary, EmployeeBook);
        System.out.println("\nПоказать всех сотрудников с зарплатами ниже " + divisionBySalary);
        showEmployeeWithSmallSalary(divisionBySalary, EmployeeBook);
    }

    public static void allEmployeeToPrint(Employee[] employeeBook) {
        for (Employee e : employeeBook
        ) {
            if (e != null) {
                System.out.println(e.toString());
            }
        }
    }
    public static int amountSalaryOfAllEmployeers(Employee[] employeeBook) {
        int sum = 0;
        for (Employee w : employeeBook
            ) {
            if (w != null) {
                sum+=w.getSalary();
            }
        }
        return sum;
    }
    public static Employee minimalSalaryEmployee(Employee[] employeeBook) {
        int min=0;
        int idEmployee=0;
        for (int i = 0; i < employeeBook.length; i++) {
            if(employeeBook[i] != null) {
                min = employeeBook[i].getSalary();
            }
        }
        for (int i = 0; i < employeeBook.length; i++) {
            if(employeeBook[i] != null) {
                if (employeeBook[i].getSalary() < min){
                    min = employeeBook[i].getSalary();
                    idEmployee = i;
                }
            }
        }
        return employeeBook[idEmployee];
    }
    public static Employee maximumSalaryEmployee(Employee[] employeeBook) {
        int max=0;
        int idEmployee=0;
        for (int i = 0; i < employeeBook.length; i++) {
            if(employeeBook[i] != null) {
                if (employeeBook[i].getSalary() > max){
                    max = employeeBook[i].getSalary();
                    idEmployee = i;
                }
            }
        }
        return employeeBook[idEmployee];
    }
    public static int numEmployeers(Employee[] employeeBook) {
        int num = 0;
        for (Employee w : employeeBook
        ) {
            if (w != null) {
                num++;
            }
        }
        return num;
    }
    public static void salaryIndexation(double indexaationCoefficient, Employee[] employeeBook) {
        for (Employee w : employeeBook
        ) {
            int salary;
            if (w != null) {
                salary = (int) ((1 + indexaationCoefficient)*(w.getSalary()));
                w.setSalary(salary);
            }
        }
    }

    public static void showEmployeeWithSmallSalary (int division, Employee[] employeeBook) {
        for (Employee e : employeeBook
        ) {
            if (e != null) {
                 if (e.getSalary() < division) {
                     System.out.println(e.toString());
                 }
            }
        }
    }
    public static void showEmployeeWithHighSalary (int division, Employee[] employeeBook) {
        for (Employee e : employeeBook
        ) {
            if (e != null) {
                if (e.getSalary() > division) {
                    System.out.println(e.toString());
                }
            }
        }
    }
}