package pro.sky.java.course1.CourseWork1;

import java.util.Objects;

public class Employee {
    public static int id = 0;
    private String lastName;
    private String firstName;
    private String patronymic;
    private int departmentNumber;
    private int salary;
    private int idEmployee;

    public Employee(String lastName, String patronymic, String firstName, int departmentNumber, int salary) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.departmentNumber = departmentNumber;
        this.salary = salary;
        idEmployee = id;
        id++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public int getSalary() {
        return salary;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toStringFullName() {
        return lastName + " " + firstName + " " + patronymic;
    }

    public String toStringWithoutDepartmentNumber() {
        return "Ф.И.О. " + toStringFullName() +
                "\nНомер департамента " + departmentNumber +
                "\nЗарплата " + salary;
    }

    @Override
    public String toString() {
        return "Ф.И.О. " + toStringFullName() +
                "\nНомер департамента " + departmentNumber +
                "\nЗарплата " + salary +
                "\nid " + idEmployee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return departmentNumber == employee.departmentNumber
                && salary == employee.salary
                && idEmployee == employee.idEmployee
                && firstName.equals(employee.firstName)
                && patronymic.equals(employee.patronymic)
                && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, patronymic, lastName, departmentNumber, salary, idEmployee);
    }
}
