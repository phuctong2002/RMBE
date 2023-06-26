package com.example.rmbe.controller;

import com.example.rmbe.dto.DepartmentDTO;
import com.example.rmbe.dto.RelationDTO;
import com.example.rmbe.entity.Department;
import com.example.rmbe.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("")
    public ResponseEntity<Object> addDepartment(@RequestBody DepartmentDTO departmentDTO){
        departmentService.addDepartment(departmentDTO);
        return null;
    }
    @GetMapping("/")
    public ResponseEntity<Object> getAllDepartments(){
        return new ResponseEntity<>(departmentService.getAllDepartments(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteDepartment(@PathVariable int id){
        departmentService.deleteDepartment(id);
        return null;
    }
    @GetMapping("/relation/{id}")
    public ResponseEntity<Object> getRelation(@PathVariable int id){
        return new ResponseEntity<>(departmentService.getRelationByDepartment(id), HttpStatus.OK);
    }
    @PostMapping("/relation")
    public ResponseEntity<Object> addRelation(@RequestBody RelationDTO relationDTO){
        departmentService.addRelation(relationDTO);
        return null;
    }
}
