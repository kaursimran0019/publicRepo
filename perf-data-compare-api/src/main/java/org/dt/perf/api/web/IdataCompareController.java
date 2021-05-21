package org.dt.perf.api.web;


import org.dt.perf.api.request.PerfInputRequest;
import org.dt.perf.api.response.PerfDataResponse;

public interface IdataCompareController {

    ResponseEntity<PerfDataResponse> getTheComparison(PerfInputRequest perfInputRequest);



}
