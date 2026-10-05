/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.moogata.service;

import com.example.moogata.dao.EmployeeDao;
import com.example.moogata.model.Employee;

/**
 *
 * @author Windows
 */
public class EmployeeService {

    private final EmployeeDao employeeDao = new EmployeeDao();

    /**
     * ล็อกอินพนักงานเข้าระบบ POS — ตรงกับ use case ของร้าน BONUS SUKI
     * ที่แคชเชียร์/ผู้จัดการต้องล็อกอินก่อนเปิดโต๊ะหรือคิดเงิน
     *
     * @return วัตถุ Employee เมื่อชื่อและรหัสผ่านถูกต้อง, null เมื่อไม่ถูกต้อง
     */
    public Employee login(String name, String password) {
        Employee employee = employeeDao.getByName(name);
        if (employee != null && employee.getPassword().equals(password)) {
            return employee;
        }
        return null;
    }

    // คำเตือนเชิงวิชาการ: การเก็บรหัสผ่านเป็น plain text แล้วเทียบด้วย equals
    // เหมาะเฉพาะระดับฝึกหัด — ระบบจริงต้องเก็บ hash (เช่น bcrypt) และเทียบ hash
}
