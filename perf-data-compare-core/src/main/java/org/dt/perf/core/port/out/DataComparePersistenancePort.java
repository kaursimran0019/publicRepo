package org.dt.perf.core.port.out;


import org.dt.perf.api.model.PerfData;
import org.dt.perf.api.request.PerfInputRequest;
import org.dt.perf.api.response.PerfDataResponse;

import java.util.List;

public interface DataComparePersistenancePort {
    Object getAllPerf();
    Object findById(Integer id);
    List<PerfData> findByMetaId(Integer id);
    PerfDataResponse getComparisonData(PerfInputRequest perfInputRequest);
}