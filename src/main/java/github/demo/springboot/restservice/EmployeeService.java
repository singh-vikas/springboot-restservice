package github.demo.springboot.restservice;

import github.demo.springboot.restservice.database.EmployeePersistence;
import github.demo.springboot.restservice.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EmployeeService {

  private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

  private AtomicInteger counter = new AtomicInteger(0);
  private final EmployeePersistence repository = EmployeePersistence.getEmployeePersistence();

  /**
   * Add a new employee.
   *
   * @param employee
   * @return
   */
  public String addEmployee(Employee employee) {
    employee.setId(counter.incrementAndGet());
    log.info("New employee added:" + employee.getId());
    return repository.addEmployee(employee);
  }

  /**
   * Remove a single employee.
   *
   * @param id
   * @return
   */
  public String removeEmployee(int id) {
    return repository.removeEmployee(id);
  }

  /**
   * Get all the employee.
   *
   * @return
   */
  public String getEmployee(int id) {
    return repository.getEmployee(id);
  }

  /**
   * Get all the employee.
   *
   * @return
   */
  public String getAllEmployee() {
    return repository.getAllEmployee();
  }

}
