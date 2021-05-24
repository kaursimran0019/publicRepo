package org.dt.perf.core.port.in;

import org.dt.perf.api.model.PerfData;
import org.dt.perf.api.response.PerfDataResponse;

import java.util.List;

public interface DataCompareServicePort {

    Object getAllPerf();
    Object findById(Integer id);
    List<PerfData> findByMetaId(Integer id);
    PerfDataResponse getComparisonData(org.dt.perf.api.request.PerfInputRequest perfInputRequest);
}
