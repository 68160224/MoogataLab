/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.moogata.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Windows
 */
public class Employee {

    private int id;            // ← คอลัมน์ employee_id
    private String name;       // ← คอลัมน์ employee_name  (ชื่อล็อกอิน UNIQUE เช่น somchai)
    private String position;   // ← คอลัมน์ employee_position (แคชเชียร์ / ผู้จัดการ)
    private String password;   // ← คอลัมน์ employee_password
    private int role;          // ← คอลัมน์ employee_role (1 = ผู้จัดการ, 2 = พนักงานทั่วไป)

    public Employee(int id, String name, String position, String password, int role) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.password = password;
        this.role = role;
    }

    /**
     * สำหรับพนักงานใหม่ที่ยังไม่มี id (id จะถูกสร้างตอน save ผ่าน
     * AUTOINCREMENT)
     */
    public Employee(String name, String position, String password, int role) {
        this(-1, name, position, password, role);
    }

    public Employee() {
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", position=" + position
                + ", role=" + role + '}';
    }

    /**
     * แปลงแถวข้อมูลจาก ResultSet เป็นวัตถุ Employee แถวปัจจุบันของ rs
     * ต้องถูกเรียก rs.next() แล้วเท่านั้น
     */
    public static Employee fromRS(ResultSet rs) throws SQLException {
        Employee emp = new Employee();
        emp.setId(rs.getInt("employee_id"));
        emp.setName(rs.getString("employee_name"));
        emp.setPosition(rs.getString("employee_position"));
        emp.setPassword(rs.getString("employee_password"));
        emp.setRole(rs.getInt("employee_role"));
        return emp;
    }
}
