package com.truemeds.testanurag.repository;

import com.truemeds.testanurag.model.ReduceResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends CrudRepository<ReduceResult, Long> {
}
