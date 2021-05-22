package org.dt.perf.api.web;


import org.dt.perf.api.request.PerfInputRequest;
import org.dt.perf.api.response.PerfDataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface IdataCompareController {

    @PostMapping (path = "/qwerty")
    ResponseEntity<PerfDataResponse> getTheComparison(@RequestBody PerfInputRequest perfInputRequest);
}
