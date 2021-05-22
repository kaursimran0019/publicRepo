package org.dt.perf.adapter.web;

import org.dt.perf.api.request.PerfInputRequest;
import org.dt.perf.api.response.PerfDataResponse;
import org.dt.perf.api.web.IdataCompareController;
import org.springframework.http.ResponseEntity;

public class DataCompareController implements IdataCompareController {

    @Override
    public ResponseEntity<PerfDataResponse> getTheComparison(PerfInputRequest perfInputRequest) {
        return null;
    }
}
