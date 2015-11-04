package org.onderdal;

import org.onderdal.base.BaseDAO;
import org.onderdal.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by onder.dal on 03.11.2015.
 * package: org.onderdal
 *
 * @author Önder DAL  The type User dao.
 */
@Repository("userDAO")
public class UserDAO extends BaseDAO {

    /**
     * Gets by login name.
     * @author Önder DAL  Gets by login name.
     * @param loginName the login name
     * @return the by login name
     */
    public User getByLoginName(String loginName) {
        String hql = "from User u where u.loginName = :loginName and u.deleted = false and u.enabled = true";
        Query query = createQuery(hql);
        query.setParameter("loginName", loginName);
        try {
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            //Sonuç yok ise
            return null;
        }
    }

    /**
     * Get all.
     * @author onder.dal *
     * @return the list
     */
    public List<User> getAll(){
        String hql = "from User ";
        Query query = createQuery(hql);
        return query.getResultList();
    }

}
