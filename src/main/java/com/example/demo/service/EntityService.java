package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Entity;
import org.springframework.data.jpa.repository.Query;

/**
 * The interface Entity service.
 */
public interface EntityService {

  /**
   * Find by prefix list.
   *
   * @param initial the initial
   * @return the list
   */
  /*
   * validate DB2 use the query, run the below within H2 console:
   * SET TRACE_LEVEL_SYSTEM_OUT 3;
   * or
   * SET TRACE_LEVEL_FILE 3;
   */
  @Query("SELECT * FROM ENTITY WHERE INITIAL = ?1")
  List<Entity> findByPrefix(String initial);
}
