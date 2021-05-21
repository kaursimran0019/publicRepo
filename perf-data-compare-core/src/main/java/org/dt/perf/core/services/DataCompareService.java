package org.dt.perf.core.services;

import org.dt.perf.api.request.PerfInputRequest;
import org.dt.perf.api.response.PerfDataResponse;
import org.dt.perf.core.port.in.DataCompareServicePort;

public class DataCompareService implements DataCompareServicePort {
    @Override
    public PerfDataResponse getComparisonData(PerfInputRequest perfInputRequest) {
        return null;
    }
}
