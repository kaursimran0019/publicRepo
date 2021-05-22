package org.dt.perf.core.services;

import org.dt.perf.core.domain.PerfDataResponse;
import org.dt.perf.core.domain.PerfInputRequest;
import org.dt.perf.core.port.in.DataCompareServicePort;

public class DataCompareService implements DataCompareServicePort {

    @Override
    public PerfDataResponse getComparisonData(PerfInputRequest perfInputRequest) {
        //Validate the Data
        //CAll the Database Function and get the Response.

        return null;
    }
}
