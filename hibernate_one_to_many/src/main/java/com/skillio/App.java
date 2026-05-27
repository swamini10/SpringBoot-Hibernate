package com.skillio;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {

        Configuration cf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Document.class)
                .addAnnotatedClass(Person.class);

        SessionFactory sf = cf.buildSessionFactory();

        Session session = sf.openSession();

        session.beginTransaction();

        // PERSONS
        Person person = new Person();
        person.setId(1);
        person.setName("Swamini");
        person.setAddress("Pune");

        Person person1 = new Person();
        person1.setId(2);
        person1.setName("Soham");
        person1.setAddress("Pune");

        // DOCUMENTS
        Document doc1 = new Document();
        doc1.setId(101);
        doc1.setType("Aadhar");
        doc1.setNumber("123456");
        
        Document doc2 = new Document();
        doc2.setId(102);
        doc2.setType("PAN");
        doc2.setNumber("abc321");
        
        Document doc3 = new Document();
        doc3.setId(103);
        doc3.setType("PAN");
        doc3.setNumber("QWE321");

        // SAVE DOCUMENTS FIRST
        session.persist(doc1);
        session.persist(doc2);
        session.persist(doc3);
        
        List<Document> docs1 = new ArrayList<>();
        docs1.add(doc1);
        docs1.add(doc2);
        
        List<Document> docs2 = new ArrayList<>();
        docs2.add(doc3);

        // ASSIGN DOCUMENTS
        person.setDocs(docs1);
        person1.setDocs(docs2);

        // SAVE PERSONS
        session.persist(person);
        session.persist(person1);

        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}