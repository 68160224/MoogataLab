/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.moogata.dao;

import java.util.List;

/**
 *
 * @author Windows
 */
public interface Dao<T> {

    /**
     * ค้นหา 1 แถวจาก primary key — ไม่พบคืน null
     */
    T get(int id);

    /**
     * คืนทุกแถวในตาราง
     */
    List<T> getAll();

    /**
     * เพิ่มแถวใหม่ — สำเร็จจะได้ object กลับมาพร้อม id ที่ฐานข้อมูลสร้างให้
     * ล้มเหลวคืน null
     */
    T save(T obj);

    /**
     * แก้ไขแถวตาม id ของ object — สำเร็จคืน object ไม่พบแถว/ล้มเหลวคืน null
     */
    T update(T obj);

    /**
     * ลบแถว — คืนจำนวนแถวที่ถูกลบ (0 = ไม่พบ, -1 = ผิดพลาด)
     */
    int delete(T obj);

    /**
     * ค้นหาแบบกำหนดเงื่อนไข/เรียงลำดับเองได้ (สำหรับโจทย์ท้าทาย) ตัวอย่าง:
     * getAll("employee_role = 2", "employee_name ASC")
     */
    List<T> getAll(String where, String order);
}
