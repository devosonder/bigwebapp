package org.onderdal.base;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Map;

/**
 * Created by onder.dal on 03.11.2015.
 * package: org.onderdal.base
 * @author onder.dal
 */
public class BaseDAO {
    /**
     * The Entity manager.
     */
    @PersistenceContext
    public EntityManager entityManager;

    /**
     * Create query.
     * @author onder.dal *
     * @param query the query
     * @return the query
     */
    public Query createQuery(String query) {
        return entityManager.createQuery(query);
    }

    /**
     * Update t.
     * @author onder.dal *
     * @param <T>  the type parameter
     * @param entity the entity
     * @return the t
     */
    public <T> T update(T entity) {
        return entityManager.merge(entity);
    }

    /**
     * Save or update.
     * @author onder.dal *
     * @param entity the entity
     */
    public void saveOrUpdate(Object entity) {
        entityManager.persist(entity);
    }

    /**
     * Remove void.
     * @author onder.dal *
     * @param entity the entity
     */
    public void remove(Object entity){
        entityManager.remove(entity);
    }

    /**
     * Gets by id.
     * @author onder.dal *
     * @param clazz the clazz
     * @param id the id
     * @return the by id
     */
    public Object getById(Class clazz, Object id) {
        return clazz.cast(entityManager.find(clazz, id));
    }

    /**
     * Gets by id.
     * @author onder.dal *
     * @param clazz the clazz
     * @param id the id
     * @param properties the properties
     * @return the by id
     */
    public Object getById(Class clazz, Object id, Map<String,Object> properties) {
        return clazz.cast(entityManager.find(clazz, id, properties));
    }

    /**
     * Gets by id.
     * @author onder.dal *
     * @param clazz the clazz
     * @param id the id
     * @param lockModeType the lock mode type
     * @param properties the properties
     * @return the by id
     */
    public Object getById(Class clazz, Object id, LockModeType lockModeType, Map<String,Object> properties) {
        return clazz.cast(entityManager.find(clazz, id, lockModeType, properties));
    }

    /**
     * Gets by id.
     * @author onder.dal *
     * @param clazz the clazz
     * @param id the id
     * @param lockModeType the lock mode type
     * @return the by id
     */
    public Object getById(Class clazz, Object id, LockModeType lockModeType) {
        return clazz.cast(entityManager.find(clazz, id, lockModeType));
    }
}
