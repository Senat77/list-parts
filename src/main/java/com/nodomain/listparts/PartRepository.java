package com.nodomain.listparts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartRepository extends JpaRepository<Part, Long> {
    @Query(
            "select p from Part p " +
                    "where lower(p.name) like concat('%', lower(?1), '%') and " +
                    "((?2 is null) or (p.necessary = ?2))"
    )
    Page<Part> findByName(String search, Boolean necessary, Pageable pageable);

    @Query
    Part findFirstByNecessaryIsTrueOrderByAmount();
}
