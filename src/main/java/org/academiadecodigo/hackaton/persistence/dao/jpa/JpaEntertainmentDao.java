package org.academiadecodigo.hackaton.persistence.dao.jpa;

import org.academiadecodigo.hackaton.persistence.dao.EntertainmentDao;
import org.academiadecodigo.hackaton.persistence.model.entertainment.Entertainment;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * A JPA {@link EntertainmentDao} implementation
 */
@Repository
public class JpaEntertainmentDao extends GenericJpaDao<Entertainment> implements EntertainmentDao {
    /**
     * Initializes a new JPA DAO instance given a model type
     */
    public JpaEntertainmentDao() {
        super(Entertainment.class);
    }

    @Override
    public List<Entertainment> findAllByType(String entertainmentType) {

        CriteriaQuery<Entertainment> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        Root<Entertainment> root = criteriaQuery.from(modelType);
        criteriaQuery.select(root);
        criteriaQuery.where(em.getCriteriaBuilder().equal(root.get("entertainment_type"), entertainmentType));
        return em.createQuery(criteriaQuery).getResultList();
    }
}
