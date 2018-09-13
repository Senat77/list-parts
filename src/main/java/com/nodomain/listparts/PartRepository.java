package com.nodomain.listparts;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PartRepository extends CrudRepository<Part,Long>
{
    List<Part> findByName(String name);
}
