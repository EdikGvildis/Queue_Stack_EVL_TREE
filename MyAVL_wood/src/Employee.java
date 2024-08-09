import java.util.Objects;

public class Employee {
    int height;
    Employee right;
    Employee left;
    int salary;
    String name;
    IT pos;

    public Employee(int height, int salary, String name, IT pos) {
        this.height = height;
        this.salary = salary;
        this.name = name;
        this.pos = pos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return height == employee.height && salary == employee.salary && Objects.equals(right, employee.right) && Objects.equals(left, employee.left) && Objects.equals(name, employee.name) && pos == employee.pos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, right, left, salary, name, pos);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "height=" + height +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", pos=" + pos +
                '}';
    }
}
