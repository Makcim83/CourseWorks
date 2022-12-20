package pro.sky.java.course1.CourseWork1;

public class Main {
    public static Employee EmployeeBook[] = new Employee[10];
    public static void main(String[] args) {

        EmployeeBook[0] = new Employee("Иванов", "Иван", "Иванович", 1, 30000);
        EmployeeBook[1] = new Employee("Петров", "Иван", "Степаный", 2, 40000);
        EmployeeBook[2] = new Employee("Сидоров", "Иван", "Фомиич", 3, 50000);
        EmployeeBook[3] = new Employee("Кузнецов", "Иван", "Кузмич", 4, 60000);
        EmployeeBook[4] = new Employee("Романов", "Роман", "Иванович", 5, 70000);

        allEmployeeToPrint();
        System.out.println("Сумма затрат на зарплату " + amountSalaryOfAllEmployeers());
        System.out.println("Сотрудник с минимальной зарплатой " + minimalSalaryEmployee().toStringFullName());
        System.out.println("Сотрудник с максимальной зарплатой " + maximumSalaryEmployee().toStringFullName());
        System.out.println("Среднее значение зарплат " + amountSalaryOfAllEmployeers() / numEmployeers());

    }

    public static void allEmployeeToPrint() {
        for (Employee w : EmployeeBook
        ) {
            if (w != null) {
                System.out.println(w.toString());
            }
        }
    }
    public static int amountSalaryOfAllEmployeers() {
        int sum = 0;
        for (Employee w : EmployeeBook
            ) {
            if (w != null) {
                sum+=w.getSalary();
            }
        }
        return sum;
    }
    public static Employee minimalSalaryEmployee() {
        int min=0;
        int idEmployee=0;
        for (int i = 0; i < EmployeeBook.length; i++) {
            if(EmployeeBook[i] != null) {
                min = EmployeeBook[i].getSalary();
            }
        }
        for (int i = 0; i < EmployeeBook.length; i++) {
            if(EmployeeBook[i] != null) {
                if (EmployeeBook[i].getSalary() < min){
                    min = EmployeeBook[i].getSalary();
                    idEmployee = i;
                }
            }
        }
        return EmployeeBook[idEmployee];
    }
    public static Employee maximumSalaryEmployee() {
        int max=0;
        int idEmployee=0;
        for (int i = 0; i < EmployeeBook.length; i++) {
            if(EmployeeBook[i] != null) {
                if (EmployeeBook[i].getSalary() > max){
                    max = EmployeeBook[i].getSalary();
                    idEmployee = i;
                }
            }
        }
        return EmployeeBook[idEmployee];
    }
    public static int numEmployeers() {
        int num = 0;
        for (Employee w : EmployeeBook
        ) {
            if (w != null) {
                num++;
            }
        }
        return num;
    }
}