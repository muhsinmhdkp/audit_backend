package com.ust.audit.api.benchmark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenchMarkRepository extends JpaRepository<BenchMarkEntity,Integer> {

}
