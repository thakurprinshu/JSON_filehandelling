package employ_management;

import java.util.List;

class Address {
    private String street;
    private String city;
    private String zipcode;

    public Address(String street, String city, String zipcode) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }
}

class Project {
    private int projectId;
    private String projectName;
    private String status;

    public Project(int projectId, String projectName, String status) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.status = status;
    }
}

class Employee {
    private int employeeId;
    private String name;
    private String department;
    private Address address;
    private List<Project> projects;

    public Employee(int employeeId, String name, String department,
                    Address address, List<Project> projects) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.address = address;
        this.projects = projects;
    }
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}

