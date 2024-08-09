import java.util.ArrayList;
import java.util.List;

public class Organization {
    private Employee root;
    //1 МЕТОД
    public List<Employee> getEmployees(int N) {
        List<Employee> employees = new ArrayList<>();
        getEmployees1(root, N, employees);
        return employees;
    }

    private void getEmployees1(Employee current, int N, List<Employee> employees) {
        if (current != null) {
            if (current.salary > N) {
                employees.add(current);
            }
            getEmployees1(current.left, N, employees);
            getEmployees1(current.right, N, employees);
        }
    }
    // 2 Метод
    public boolean exists(int salary) {
        return existsRecursive(root, salary);
    }

    private boolean existsRecursive(Employee current, int salary) {
        if (current == null) {
            return false;
        }

        if (salary < current.salary) {
            return existsRecursive(current.left, salary);
        } else if (salary > current.salary) {
            return existsRecursive(current.right, salary);
        } else {
            return true;
        }
    }
    // 3 Метод
    public boolean add(Employee item) {
        root = addRecursive(root, item);
        return true;
    }

    private Employee addRecursive(Employee current, Employee item) {
        if (current == null) {
            return new Employee(1, item.salary, item.name, item.pos);
        }
        if (item.salary < current.salary) {
            current.left = addRecursive(current.left, item);
        } else if (item.salary > current.salary) {
            current.right = addRecursive(current.right, item);
        } else {
            System.out.println("Повторне введення числа: " + item.salary);
            return current;
        }
        current.height = 1 + Math.max(height(current.left), height(current.right));
        return balance(current);
    }
    //4 Метод
    public boolean delete(Employee item) {
        boolean[] found = {false};
        root = deleteRecursive(root, item, found);
        return found[0];
    }
    private Employee deleteRecursive(Employee current, Employee item, boolean[] found) {
        if (current == null) {
            return null;
        }

        int comparison = item.salary - current.salary;
        if (comparison < 0) {
            current.left = deleteRecursive(current.left, item, found);
        } else if (comparison > 0) {
            current.right = deleteRecursive(current.right, item, found);
        } else {
            found[0] = true;
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }
            Employee successor = findMin(current.right);
            current.salary = successor.salary;
            current.right = deleteRecursive(current.right, successor, found);
        }
        current.height = 1 + Math.max(height(current.left), height(current.right));
        return balance(current);
    }

    private Employee findMin(Employee node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    //5 Метод
    public List<Employee> getEmployeesAtLevels(int startLevel, int endLevel) {
        List<Employee> employees = new ArrayList<>();
        getEmployeesAtLevelsRecursive(root, 1, startLevel, endLevel, employees);
        return employees;
    }

    private void getEmployeesAtLevelsRecursive(Employee current, int currentLevel, int startLevel, int endLevel, List<Employee> employees) {
        if (current == null) {
            return;
        }
        if (currentLevel >= startLevel && currentLevel <= endLevel) {
            employees.add(current);
        }
        getEmployeesAtLevelsRecursive(current.left, currentLevel + 1, startLevel, endLevel, employees);
        getEmployeesAtLevelsRecursive(current.right, currentLevel + 1, startLevel, endLevel, employees);
    }
    //6 Метод
    public Employee findSibling(Employee employee) {
        if (employee == null || root == null) {
            return null;
        }

        return findSiblingRecursive(root, employee);
    }

    private Employee findSiblingRecursive(Employee current, Employee target) {
        while (current != null) {
            if (current.left.salary == target.salary ) {
                return current.right;
            } else if (current.right.salary == target.salary) {
                return current.left;
            }
            if (current.salary < target.salary) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        return null;
    }
    //7 Метод
    public void printTree() {
        printTreeRecursive(root);
    }

    private void printTreeRecursive(Employee current) {
        if (current != null) {
            printTreeRecursive(current.left);
            System.out.println(current);
            printTreeRecursive(current.right);
        }
    }
    //Додаткові Методи
    private Employee balance(Employee current) {
        int balanceFactor = getBalanceFactor(current);
        if (balanceFactor > 1) {
            if (getBalanceFactor(current.left) < 0) {
                current.left = leftRotate(current.left);
            }
            return rightRotate(current);
        }
        if (balanceFactor < -1) {
            if (getBalanceFactor(current.right) > 0) {
                current.right = rightRotate(current.right);
            }
            return leftRotate(current);
        }
        return current;
    }

    private int height(Employee node) {
        return node == null ? 0 : node.height;
    }

    private int getBalanceFactor(Employee node) {
        return height(node.left) - height(node.right);
    }

    private Employee rightRotate(Employee y) {
        Employee x = y.left;
        Employee T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private Employee leftRotate(Employee x) {
        Employee y = x.right;
        Employee T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }
}
