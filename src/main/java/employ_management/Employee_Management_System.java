package employ_management;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.*;

public class Employee_Management_System {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<Employee> employees = Employ_Storage.loadEmployees();
        int choice;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addEmployee(employees);
                case 2 -> viewAllEmployees(employees);
                case 3 -> updateEmployee(employees);
                case 4 -> deleteEmployee(employees);
                case 5 -> searchEmployee(employees);
                case 6 -> {
                    Employ_Storage.saveEmployees(employees);
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);
    }

    private static void addEmployee(List<Employee> employees) {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt(); sc.nextLine();

        for (Employee emp : employees) {
            if (emp.getEmployeeId() == id) {
                System.out.println("Employee ID already exists!");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        System.out.print("Enter Street: ");
        String street = sc.nextLine();

        System.out.print("Enter City: ");
        String city = sc.nextLine();

        System.out.print("Enter Zipcode: ");
        String zipcode = sc.nextLine();

        Address address = new Address(street, city, zipcode);

        List<Project> projects = new ArrayList<>();
        System.out.print("Enter number of projects: ");
        int n = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Project ID: ");
            int pid = sc.nextInt(); sc.nextLine();
            System.out.print("Enter Project Name: ");
            String pname = sc.nextLine();
            System.out.print("Enter Project Status: ");
            String status = sc.nextLine();
            projects.add(new Project(pid, pname, status));
        }

        employees.add(new Employee(id, name, dept, address, projects));
        System.out.println("Employee added successfully!");
    }

    private static void viewAllEmployees(List<Employee> employees) {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee emp : employees) {
            System.out.println(new Gson().toJson(emp));
        }
    }

    private static void updateEmployee(List<Employee> employees) {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt(); sc.nextLine();

        for (Employee emp : employees) {
            if (emp.getEmployeeId() == id) {
                System.out.print("Enter new Name: ");
                emp.setName(sc.nextLine());
                System.out.print("Enter new Department: ");
                emp.setDepartment(sc.nextLine());
                System.out.println("Employee updated!");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    private static void deleteEmployee(List<Employee> employees) {
        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt(); sc.nextLine();

        employees.removeIf(emp -> emp.getEmployeeId() == id);
        System.out.println("Employee deleted if existed.");
    }

    private static void searchEmployee(List<Employee> employees) {
        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt(); sc.nextLine();

        for (Employee emp : employees) {
            if (emp.getEmployeeId() == id) {
                System.out.println(new Gson().toJson(emp));
                return;
            }
        }
        System.out.println("Employee not found!");
    }
}

