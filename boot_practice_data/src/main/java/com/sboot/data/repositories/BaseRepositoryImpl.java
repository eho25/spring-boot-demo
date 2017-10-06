package com.sboot.data.repositories;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BaseRepositoryImpl<T, S extends Serializable> implements BaseRepository<T, S> {

    @PersistenceContext
    private EntityManager entityManager;

    @Value("${spring.jpa.properties.hibernate.jdbc.batch_size}")
    private int batchSize;

    @Transactional
    public List<T> batchSave(List<T> entities){
        int i = 0;
        List<T> savedEntities = new ArrayList<>();
        for(T entity : entities) {
            entityManager.persist(entity);
            ++i;
            savedEntities.add(entity);
            if (i % batchSize == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
        return savedEntities;
    }
}
