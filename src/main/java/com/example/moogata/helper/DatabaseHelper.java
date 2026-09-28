/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.moogata.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows
 */
public class DatabaseHelper {
    private static final Logger LOG = Logger.getLogger(DatabaseHelper.class.getName());

    public static final String DB_FILE = "moogata.db";

    private static final String URL = "jdbc:sqlite:" + DB_FILE;

    private static Connection conn;

    private DatabaseHelper() {
    }
    
    public static synchronized Connection getConnect() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL);
                Statement pragma = null;
                try {
                    pragma = conn.createStatement();
                    pragma.execute("PRAGMA foreign_keys = ON");
                } finally {
                    if (pragma != null) {
                        try {
                            pragma.close();
                        } catch (SQLException closeEx) {
                            System.err.println("Close pragma failed: " + closeEx.getMessage());
                        }
                    }
                }
                LOG.info("Connected to SQLite: " + DB_FILE);
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, "เชื่อมต่อฐานข้อมูลไม่สำเร็จ: " + URL, ex);
            }
        }
        return conn;
    }
    
    public static synchronized void close() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
                LOG.info("Connection closed.");
            } catch (SQLException ex) {
                LOG.log(Level.WARNING, "ปิด connection ไม่สำเร็จ", ex);
            }
        }
    }
    
    public static int getInsertedId(Statement stmt) {
        ResultSet keys = null;
        try {
            keys = stmt.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }
        } catch (SQLException ex) {
            LOG.log(Level.WARNING, "อ่าน generated key ไม่สำเร็จ", ex);
        } finally {
            if (keys != null) {
                try {
                    keys.close();
                } catch (SQLException closeEx) {
                    System.err.println("Close keys failed: " + closeEx.getMessage());
                }
            }
        }
        return -1;
    }
}
