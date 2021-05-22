package org.dt.perf.core.port.in;

import org.dt.perf.core.domain.PerfDataResponse;
import org.dt.perf.core.domain.PerfInputRequest;

public interface DataCompareServicePort {

    PerfDataResponse getComparisonData(PerfInputRequest perfInputRequest);
}
