package github.demo.springboot.restservice;

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
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class EmployeeController {

  private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

  @Autowired
  private EmployeeService service;


  @GetMapping("/employees")
  String all() {
    log.info("Returning all the employees.");
    return service.getAllEmployee();
  }

  @PostMapping("/employees")
  String addEmployee(@RequestBody Employee newEmployee) {
    return service.addEmployee(newEmployee);
  }

  @GetMapping("/employees/{id}")
  String getEmployeeBasedOnId(@PathVariable int id) {
    log.info("Employee request:" + id);
    return service.getEmployee(id);
  }

  @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
  String removeEmployee(@PathVariable int id) {
    log.info("Employee requested to be removed: " + id);
    return service.removeEmployee(id);
  }
}
