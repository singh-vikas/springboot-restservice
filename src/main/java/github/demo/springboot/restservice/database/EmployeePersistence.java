package github.demo.springboot.restservice.database;

import github.demo.springboot.restservice.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Singleton repository of employees.
 */
public class EmployeePersistence {

  private static final Logger log = LoggerFactory.getLogger(EmployeePersistence.class);

  private HashSet<Employee> employees = new HashSet<Employee>();

  private EmployeePersistence() {
  }

  private static EmployeePersistence persistence = null;

  /**
   * Only one instance of employee persistance.
   *
   * @return
   */
  public static EmployeePersistence getEmployeePersistence() {
    if (persistence == null) {
      persistence = new EmployeePersistence();
    }
    return persistence;
  }

  /**
   * Add a new employee.
   *
   * @param employee
   * @return
   */
  public String addEmployee(Employee employee) {
    if (employees.contains(employee)) {
      return "Employee exists :" + employee.toString();
    } else {
      employees.add(employee);
      return "Employee added :" + employee.toString();
    }
  }

  /**
   * Remove a single employee.
   *
   * @param id
   * @return
   */
  public String removeEmployee(int id) {

    Iterator<Employee> iterator = employees.iterator();
    if (iterator.hasNext()) {
      Employee emp = iterator.next();
      if (emp.getId() == id) {
        iterator.remove();
        return "Employee deleted :" + emp.toString();
      }
    }

    return "Employee doesn't exists. Id : " + id+ "   ";
  }

  /**
   * Get all the employee.
   * @param id
   * @return
   */
  public String getEmployee(int id) {

    Iterator<Employee> iterator = employees.iterator();

    if (iterator.hasNext()) {
      Employee emp = iterator.next();

      if (emp.getId() == id) {
        return "Employee exists :" + emp.toString();
      }
    }
    return "Employee doesn't exists :" + id;

  }

  /**
   * Get all the employee.
   *
   * @return
   */
  public String getAllEmployee() {
    return employees.toString();
  }

}
