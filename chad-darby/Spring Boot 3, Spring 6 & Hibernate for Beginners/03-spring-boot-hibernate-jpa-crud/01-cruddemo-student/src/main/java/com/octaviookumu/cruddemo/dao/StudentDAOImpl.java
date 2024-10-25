package com.octaviookumu.cruddemo.dao;

import com.octaviookumu.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository // specialized annotation for repositories. supports component scanning. translates JDBC exceptions.
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private final EntityManager entityManager;

    // inject entity manager using constructor
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional // since we are performing an update in the db
    public void save(Student theStudent) {
        entityManager.persist(theStudent); // saves the student
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id); // class and primary key
    }

    @Override
    public List<Student> findAll() {

        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        // FROM Student - Student is the name of JPA Entity... the class name
        // This is not the name of the database table

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        // create query
        TypedQuery<Student> theQuery = entityManager
                .createQuery("FROM Student WHERE lastName=:theData", Student.class);
        // JPQL named parameters are prefixed with a colon :
        // Think of this as a placeholder that is filled in later

        // set query parameters
        theQuery.setParameter("theData", theLastName);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent); // will perform an update on the student
    }

    @Override
    @Transactional
    public void delete(Integer id) {

        // retrieve the student
        Student theStudent = entityManager.find(Student.class, id);

        // delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }

}
