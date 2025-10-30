package com.example.main;

import org.hibernate.*;
import com.example.model.Employee;
import com.example.util.HibernateUtil;

public class EmployeeCRUD {

    public static void main(String[] args) {
        // CREATE
        createEmployee("Anitha", 40000);
        createEmployee("Ramesh", 52000);

        // READ
        readEmployee(1);

        // UPDATE
        updateEmployee(1, 60000);

        // DELETE
        deleteEmployee(2);

        HibernateUtil.getSessionFactory().close();
    }

    // CREATE
    public static void createEmployee(String name, double salary) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = new Employee(name, salary);
        session.save(emp);

        tx.commit();
        session.close();
        System.out.println("✅ Employee Added: " + emp);
    }

    // READ
    public static void readEmployee(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Employee emp = session.get(Employee.class, id);

        if (emp != null)
            System.out.println("👀 Employee Found: " + emp);
        else
            System.out.println("❌ Employee not found with ID: " + id);

        session.close();
    }

    // UPDATE
    public static void updateEmployee(int id, double newSalary) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            emp.setSalary(newSalary);
            session.update(emp);
            System.out.println("✏️ Updated Employee: " + emp);
        } else {
            System.out.println("❌ No Employee found to update.");
        }

        tx.commit();
        session.close();
    }

    // DELETE
    public static void deleteEmployee(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Employee emp = session.get(Employee.class, id);
        if (emp != null) {
            session.delete(emp);
            System.out.println("🗑️ Employee Deleted: " + emp);
        } else {
            System.out.println("❌ No Employee found to delete.");
        }

        tx.commit();
        session.close();
    }
}
