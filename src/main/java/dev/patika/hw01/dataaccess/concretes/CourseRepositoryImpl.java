package dev.patika.hw01.dataaccess.concretes;

import dev.patika.hw01.core.constants.DbConstants;
import dev.patika.hw01.core.helpers.EntityManagerHelper;
import dev.patika.hw01.dataaccess.abstracts.CourseRepository;
import dev.patika.hw01.entities.concretes.Course;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {

    private final EntityManagerHelper emHelper;
    private final EntityManager em;

    public CourseRepositoryImpl() {
        this.emHelper = new EntityManagerHelper(DbConstants.PERSISTENCE_UNIT_NAME);
        this.em = emHelper.getEntityManager();
    }

    @Override
    public Course findByCode(String code) {
        return em.createQuery("from Course c where c.code=:code", Course.class).setParameter("code", code).getSingleResult();
    }

    @Override
    public List<Course> findAll() {
        return em.createQuery("from Course", Course.class).getResultList();
    }

    @Override
    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    @Override
    public void save(Course entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            emHelper.close(em);
        }
    }

    @Override
    public void update(Course entity) {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            emHelper.close(em);
        }
    }

    @Override
    public void delete(Course entity) {
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            emHelper.close(em);
        }
    }

    @Override
    public void deleteById(Long id) {
        delete(em.getReference(Course.class, id));
    }
}
