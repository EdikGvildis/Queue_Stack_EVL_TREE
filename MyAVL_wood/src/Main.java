import java.util.List;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();
        Employee employee = new Employee(0,19, "Eduard",IT.HQ);
        Employee employee1 = new Employee(0,20, "Eduards1",IT.HQ);
        Employee employee2 = new Employee(0,5, "Eduards2",IT.HQ);
        Employee employee3 = new Employee(0,40, "Eduards3",IT.HQ);
        Employee employee4 = new Employee(0,30, "Eduard4",IT.HQ);
        Employee employee5 = new Employee(0,21, "Eduard5",IT.HQ);
        Employee employee6 = new Employee(0,32, "Eduard6",IT.HQ);
        Employee employee7 = new Employee(0,19, "Eduard7",IT.HQ);
        organization.add(employee);
        organization.add(employee1);
        organization.add(employee2);
        organization.add(employee3);
        organization.add(employee4);
        organization.add(employee5);
        organization.add(employee6);
        organization.add(employee7); //3
        List<Employee> employees = organization.getEmployees(20); //1
        for (var s : employees) {
            System.out.println(s);
        }
        System.out.println(organization.exists(20)); //2
        organization.delete(employee5); //4
        List<Employee> employees1 = organization.getEmployeesAtLevels(1,3); //5
        System.out.println();
        for (var s:employees1) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println(organization.findSibling(employee6));//6
        System.out.println();
        organization.printTree();//7
    }
}