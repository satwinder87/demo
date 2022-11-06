package pojo;

import com.example.demo.model.Emp;
import com.example.demo.model.Employee;
import com.example.demo.pojo.CreateCustomerRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateCustomerRequestTest {

    @Test
    public void createCustomerRequest(){

        CreateCustomerRequest request = new CreateCustomerRequest("satwinder","sa@gmail.com","stockholm");

        Assertions.assertEquals("satwinder",request.getName());
        Assertions.assertEquals("sa@gmail.com",request.getEmail());
        Assertions.assertEquals("stockholm",request.getCity());

    }

    @Test
    public void createEmployeeTest(){
        Employee emp = Employee.builder().name("satwinder").name("singh").build();
        Employee employee = Employee.builder().name("satwinder").email("sa@gmail.com").build();
        Assertions.assertEquals("satwinder",employee.getName());

        System.out.println(emp.getName() + " , " + emp.getEmail());
    }

    @Test
    public void testEmp(){
        Emp emp = Emp.builder().withName("satwinder").withEmail("sa");
        Emp emp2 = Emp.builder().withName("satwindersingh").withEmail("sa@gmail.com");
        System.out.println(emp.getName() + " , " + emp.getEmail());
        System.out.println(emp2.getName() + " , " + emp2.getEmail());
    }

    @Test
    public void testEquals(){
        String name = "satwinder";
        String other = "satwinder";
        Assertions.assertTrue(name.equals(other));
        System.out.println(name.hashCode() + " , " + other.hashCode());
    }
}
