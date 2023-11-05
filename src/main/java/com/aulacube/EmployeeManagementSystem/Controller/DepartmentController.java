package com.aulacube.EmployeeManagementSystem.Controller;

import com.aulacube.EmployeeManagementSystem.Entity.Department;
import com.aulacube.EmployeeManagementSystem.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{departmentId}")
    public Department getDepartmentById(@PathVariable String departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{departmentId}")
    public Department updateDepartment(@PathVariable String departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId, department);
    }

    @DeleteMapping("/{departmentId}")
    public void deleteDepartment(@PathVariable String departmentId) {
        departmentService.deleteDepartment(departmentId);
    }
}
