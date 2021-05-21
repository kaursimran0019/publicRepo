package org.dt.perf.core.port.in;

import org.dt.perf.api.request.PerfInputRequest;
import org.dt.perf.api.response.PerfDataResponse;

public interface DataCompareServicePort {

    PerfDataResponse getComparisonData(PerfInputRequest perfInputRequest);
}
