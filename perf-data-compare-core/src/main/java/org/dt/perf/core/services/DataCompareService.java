package org.dt.perf.core.services;

import org.dt.perf.api.model.PerfData;
import org.dt.perf.api.request.PerfInputRequest;
import org.dt.perf.api.response.PerfDataResponse;
import org.dt.perf.core.port.in.DataCompareServicePort;
import org.dt.perf.core.port.out.DataComparePersistenancePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Vector;

@Service
public class DataCompareService implements DataCompareServicePort {

    @Autowired
    DataComparePersistenancePort dataComparePersistenancePort;

    public DataCompareService(DataComparePersistenancePort dataComparePersistenancePort){
        this.dataComparePersistenancePort = dataComparePersistenancePort;
    }

    @Override
    public PerfDataResponse getComparisonData(PerfInputRequest perfInputRequest) {

        PerfDataResponse perfDataResponse = dataComparePersistenancePort.getComparisonData(perfInputRequest);
        return perfDataResponse;
    }
    public Object findById(Integer id){
        return dataComparePersistenancePort.findById(id);
    }
    public Object getAllPerf(){
        return dataComparePersistenancePort.getAllPerf();
    }

    public List<PerfData> findByMetaId(Integer id){
        return dataComparePersistenancePort.findByMetaId(id);
    }
}
//NUMBER 1