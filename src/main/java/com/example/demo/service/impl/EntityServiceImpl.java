package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Entity;
import com.example.demo.repository.EntityRepository;
import com.example.demo.service.EntityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Entity service.
 */
@Slf4j
@Service
public class EntityServiceImpl implements EntityService {

  @Autowired
  private EntityRepository repository;

  @Override
  public List<Entity> findByPrefix(final String prefix)  {
    List<Entity> filteredEntities = new ArrayList<>();

    // get relevant rows that have the right initial
    List<Entity> list = repository
            .findByInitial(String.valueOf(prefix.charAt(0)));
    log.info("Filtered list by initial: " + list);
    for (Entity candidateEntity : list) {
      if (candidateEntity.getName().startsWith(prefix)) {
        filteredEntities.add(candidateEntity);
      }
    }

    return filteredEntities;
  }
}
