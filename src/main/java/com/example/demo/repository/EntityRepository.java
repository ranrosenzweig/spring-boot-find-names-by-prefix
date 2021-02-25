package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Entity repository.
 */
@Repository
public interface EntityRepository extends JpaRepository<Entity, String> {

  /**
   * Find by initial list.
   *
   * @param initial the initial
   * @return the list
   */
  List<Entity> findByInitial(String initial);
}
