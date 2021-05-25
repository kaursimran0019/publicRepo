package org.dt.perf.adapter.mappers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.dt.perf.adapter.entity.PerfData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfDataMapper {

    @Autowired
    ObjectMapper objectMapper;

    public org.dt.perf.api.model.PerfData perfToPerfDto(PerfData perfData){
        return objectMapper.convertValue(perfData, org.dt.perf.api.model.PerfData.class);
    }

    public PerfData perfDtoToPerf(org.dt.perf.api.model.PerfData perfData){
        return objectMapper.convertValue(perfData, PerfData.class);
    }
}
