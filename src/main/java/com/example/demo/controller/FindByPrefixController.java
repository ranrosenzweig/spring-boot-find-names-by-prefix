package com.example.demo.controller;

import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.example.demo.model.Entity;
import com.example.demo.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * The type Autocomplete controller.
 */
@RestController
@Validated
public class FindByPrefixController {

  @Autowired
  private EntityService entityService;

  /**
   * Gets names by prefix.
   *
   * @param prefix the prefix
   * @return list of entities that match the given prefix
   */
  // get names start with prefix
  @RequestMapping(value = "/findByPrefix/{prefix}",
          method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public List<Entity> getNamesByPrefix(
          @PathVariable @NotBlank @Size(min = 2, max = 10) final String prefix) {
    return entityService.findByPrefix(prefix);

  }
}
