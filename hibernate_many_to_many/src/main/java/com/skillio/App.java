package com.skillio;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Stu.class)
                .addAnnotatedClass(Doc.class)
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

        // ---------- Documents ----------
        Doc doc1 = new Doc(101, "Aadhar", "123456");
        Doc doc2 = new Doc(102, "PAN", "ABC321");
        Doc doc3 = new Doc(103, "Passport", "QWE321");

        session.persist(doc1);
        session.persist(doc2);
        session.persist(doc3);

        // ---------- Student 1 Documents ----------
        List<Doc> docs1 = new ArrayList<>();
        docs1.add(doc1);
        docs1.add(doc2);

        // ---------- Student 2 Documents ----------
        List<Doc> docs2 = new ArrayList<>();
        docs2.add(doc2); // shared document
        docs2.add(doc3);

        // ---------- Students ----------
        Stu student1 = new Stu(1, "Swamini", "Pune", docs1);
        Stu student2 = new Stu(2, "Soham", "Pune", docs2);

        // ---------- Save ----------
        session.persist(student1);
        session.persist(student2);

        tx.commit();

        session.close();
        sf.close();
    }
}