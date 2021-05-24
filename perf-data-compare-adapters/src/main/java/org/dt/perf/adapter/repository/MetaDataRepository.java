package org.dt.perf.adapter.repository;

import org.dt.perf.adapter.entity.MetaData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MetaDataRepository extends CrudRepository<MetaData,Integer> {

    public MetaData findByName(String name);
}
