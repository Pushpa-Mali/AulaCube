package com.aulacube.EmployeeManagementSystem.Service;

import com.aulacube.EmployeeManagementSystem.Entity.Department;
import com.aulacube.EmployeeManagementSystem.Repository.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(String departmentId) {
        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + departmentId));
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(String departmentId, Department department) {
        Department existingDepartment = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + departmentId));
        existingDepartment.setDepartmentName(department.getDepartmentName());
        existingDepartment.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return departmentRepository.save(existingDepartment);
    }

    public void deleteDepartment(String departmentId) {
        if (departmentRepository.existsById(departmentId)) {
            departmentRepository.deleteById(departmentId);
        } else {
            throw new EntityNotFoundException("Department not found with id: " + departmentId);
        }
    }
}
