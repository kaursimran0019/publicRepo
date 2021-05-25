package org.dt.perf.adapter.repository;


import org.dt.perf.adapter.entity.PerfData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerfDataRepository extends CrudRepository<PerfData,Integer> {

    public List<org.dt.perf.api.model.PerfData> findByMetaId(Integer metaId);

}
