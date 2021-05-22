package org.dt.perf.adapter.repository;


import org.dt.perf.adapter.entity.PerfData;
import org.springframework.data.repository.CrudRepository;

//@Repository
public interface PerfDataRepository extends CrudRepository<PerfData,Integer> {
}
