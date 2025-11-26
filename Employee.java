public class Employee extends Person {
    private static int employeeCounter = 1;
    private String employeeId;
    private String position;
    private double salary;
    private int hoursWorked;

    public Employee(String name, String phoneNumber, String position, double salary) {
        super(name, phoneNumber);
        this.employeeId = String.format("E%03d", employeeCounter++);
        this.position = position;
        this.salary = salary;
        this.hoursWorked = 0;
    }

    public void addHoursWorked(int hours) {
        this.hoursWorked += hours;
    }

    public double calculateSalary() {
        if (hoursWorked <= 160) return salary;
        int extraHours = hoursWorked - 160;
        return salary + ((extraHours / 160.0) * (salary * 1.5));
    }

    public String getEmployeeId() { return employeeId; }
    public int getHoursWorked() { return hoursWorked; }

    @Override
    public String getInfo() {
        return String.format("ID: %s, Name: %s, Phone:%s, Position: %s, HoursWorked: %d",
                employeeId, getName(), getPhoneNumber(), position, hoursWorked);
    }
}