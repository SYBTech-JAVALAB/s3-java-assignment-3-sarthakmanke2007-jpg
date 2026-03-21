import java.util.Scanner;

class PayrollSystem {
    private int employeeID;

    public PayrollSystem(int employeeID) {
        this.employeeID = employeeID;
    }

    public double computeSalary(int hoursWorked, double rate) {
        return hoursWorked * rate;
    }

    public double computeSalary(double baseSalary, double bonus) {
        return baseSalary + bonus;
    }

    public double computeSalary(double annualSalary) {
        return annualSalary;
    }

    public double computeSalary(double hoursWorked, double rate, double overtimeHours, double overtimeRate) {
        double base = hoursWorked * rate;
        double overtime = overtimeHours * overtimeRate;
        return base + overtime;
    }

    public double computeSalary(double baseSalary, double deductions, boolean applyDeduction) {
        if (applyDeduction) {
            return baseSalary - deductions;
        }
        return baseSalary;
    }

    public double computeSalary(double baseSalary, double bonus, double deductions) {
        return (baseSalary + bonus) - deductions;
    }

    public void displayEmployee() {
        System.out.println("Employee ID: " + employeeID);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter Employee ID: ");
            int id = sc.nextInt();
            PayrollSystem emp = new PayrollSystem(id);

            emp.displayEmployee();

            System.out.println("Choose salary computation method:");
            System.out.println("1. Hourly Salary");
            System.out.println("2. Salary with Bonus");
            System.out.println("3. Annual Salary");
            System.out.println("4. Salary with Overtime");
            System.out.println("5. Salary with Deductions");
            System.out.println("6. Salary with Bonus & Deductions");

            int choice = sc.nextInt();
            double salary = 0;

            switch (choice) {
                case 1:
                    System.out.print("Enter hours worked: ");
                    int hours = sc.nextInt();
                    System.out.print("Enter rate per hour: ");
                    double rate = sc.nextDouble();
                    salary = emp.computeSalary(hours, rate);
                    break;
                case 2:
                    System.out.print("Enter base salary: ");
                    double base = sc.nextDouble();
                    System.out.print("Enter bonus: ");
                    double bonus = sc.nextDouble();
                    salary = emp.computeSalary(base, bonus);
                    break;
                case 3:
                    System.out.print("Enter annual salary: ");
                    double annual = sc.nextDouble();
                    salary = emp.computeSalary(annual);
                    break;
                case 4:
                    System.out.print("Enter hours worked: ");
                    double h = sc.nextDouble();
                    System.out.print("Enter rate per hour: ");
                    double r = sc.nextDouble();
                    System.out.print("Enter overtime hours: ");
                    double oh = sc.nextDouble();
                    System.out.print("Enter overtime rate: ");
                    double or = sc.nextDouble();
                    salary = emp.computeSalary(h, r, oh, or);
                    break;
                case 5:
                    System.out.print("Enter base salary: ");
                    double bs = sc.nextDouble();
                    System.out.print("Enter deductions: ");
                    double ded = sc.nextDouble();
                    salary = emp.computeSalary(bs, ded, true);
                    break;
                case 6:
                    System.out.print("Enter base salary: ");
                    double b = sc.nextDouble();
                    System.out.print("Enter bonus: ");
                    double bo = sc.nextDouble();
                    System.out.print("Enter deductions: ");
                    double d = sc.nextDouble();
                    salary = emp.computeSalary(b, bo, d);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            System.out.println("Final Computed Salary: " + salary);
        }

        sc.close();
    }
}
