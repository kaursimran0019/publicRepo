package org.dt.perf.api.web;


import org.dt.perf.api.request.PerfInputRequest;
import org.dt.perf.api.response.PerfDataResponse;
import org.springframework.http.ResponseEntity;

public interface IdataCompareController {

    ResponseEntity<PerfDataResponse> getTheComparison(PerfInputRequest perfInputRequest);
}
