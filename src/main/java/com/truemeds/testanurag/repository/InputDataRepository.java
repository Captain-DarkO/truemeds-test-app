package com.truemeds.testanurag.repository;

import com.truemeds.testanurag.model.InputString;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputDataRepository extends CrudRepository<InputString, Long> {
}
