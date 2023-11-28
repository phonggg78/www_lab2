package vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.models.Employee;
import vn.edu.iuh.fit.lab1_vanquangphong_week2.backend.services.EmployeeServices;

import java.util.logging.Logger;

public class EmployeeResource {
    private final EmployeeServices employeeServices;
    private final Logger logger = (Logger) LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeResource() {
        employeeServices = new EmployeeServices();
    }

    @GET
    @Path("/{id}")
    @Produces("/application/json")
    public Response EmployeeFindbyID(@PathParam("id") long id) {
        Employee employee = employeeServices.findById(id);
        return Response.ok(employee).build();
    }
    @POST
    @Path("/createEmployee")
    @Produces("/application/json")
    public Response createEmployee(Employee employee){
        employeeServices.insertEmp(employee);
        return  Response.ok(employee).build();
    }
}
