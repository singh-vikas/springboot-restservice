package github.demo.springboot.restservice;

import github.demo.springboot.restservice.database.EmployeePersistence;
import github.demo.springboot.restservice.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class EmployeeController {

  private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

  private final EmployeePersistence repository = EmployeePersistence.getEmployeePersistence();
  private AtomicInteger counter = new AtomicInteger(0);

  @GetMapping("/employees")
  String all() {
    log.info("Returning all the employees.");
    return repository.getAllEmployee();
  }

  @PostMapping("/employees")
  String addEmployee(@RequestBody Employee newEmployee) {
    newEmployee.setId(counter.incrementAndGet());
    log.info("New employee added:" + newEmployee.getId());
    return repository.addEmployee(newEmployee);
  }

  @GetMapping("/employees/{id}")
  String getEmployeeBasedOnId(@PathVariable int id) {
    log.info("Employee request:" + id);
    return repository.getEmployee(id);
  }

  @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
  String removeEmployee(@PathVariable int id) {
    log.info("Employee requested to be removed: " + id);
    return repository.removeEmployee(id);
  }
}
