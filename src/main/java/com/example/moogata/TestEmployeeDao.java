/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.moogata;

import com.example.moogata.dao.EmployeeDao;
import com.example.moogata.helper.DatabaseHelper;
import com.example.moogata.model.Employee;

/**
 *
 * @author Windows
 */
public class TestEmployeeDao {

    public static void main(String[] args) {
        try {
            EmployeeDao employeeDao = new EmployeeDao();

            System.out.println("--- getAll(): พนักงานทุกคน ---");
            for (Employee emp : employeeDao.getAll()) {
                System.out.println(emp);
            }

            System.out.println("--- getAll(where, order): role = 2 เรียงตามชื่อ ---");
            for (Employee emp : employeeDao.getAll("employee_role = 2", "employee_name ASC")) {
                System.out.println(emp);
            }

            /*
             * === แบบฝึกหัด 1 (ดูโจทย์เต็มท้ายเอกสาร) — เปิดโค้ดข้อ 1.1–1.4 พร้อมกัน แล้วรันหนึ่งครั้ง ===
             *
             * 1.1 ค้นหาด้วย id
             * Employee found = employeeDao.get(2);
             * System.out.println("get(2) = " + found);
             *
             * 1.2 เพิ่มพนักงานใหม่ (รันครั้งเดียว รันซ้ำจะโดน UNIQUE ปฏิเสธ)
             * Employee newbie = new Employee("nongcream", "พนักงานเสิร์ฟ", "1234", 2);
             * newbie = employeeDao.save(newbie);
             * System.out.println("saved = " + newbie);
             *
             * 1.3 แก้ไข (เปลี่ยนตำแหน่ง) แล้วกลับไปกด Refresh ใน Letos
             * if (newbie != null) {
             *     newbie.setPosition("หัวหน้ากะ");
             *     employeeDao.update(newbie);
             *     System.out.println("after update = " + employeeDao.get(newbie.getId()));
             * }
             *
             * 1.4 ลบทิ้งเพื่อคืนสภาพเดิม
             * if (newbie != null) {
             *     System.out.println("deleted rows = " + employeeDao.delete(newbie));
             * }
             */
        } finally {
            DatabaseHelper.close();
        }
    }
}
