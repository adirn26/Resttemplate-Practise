package com.employee.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputModel {
    public int id;
    public String empname;
    public int deptno;
    public String deptname;
}
