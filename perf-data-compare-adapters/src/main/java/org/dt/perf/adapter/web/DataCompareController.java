package org.dt.perf.adapter.web;

import lombok.AllArgsConstructor;
import org.dt.perf.adapter.repository.PerfDataRepository;
import org.dt.perf.api.request.PerfInputRequest;
import org.dt.perf.api.response.PerfDataResponse;
import org.dt.perf.api.web.IdataCompareController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/demo")
@AllArgsConstructor
public class DataCompareController implements IdataCompareController {


    private PerfDataRepository perfDataRepository;

    @Override
    public ResponseEntity<PerfDataResponse> getTheComparison(@RequestBody PerfInputRequest perfInputRequest) {
        return ResponseEntity.ok(PerfDataResponse.builder().message("BUIOJ").build());
    }


    @GetMapping(path = "/po")
    public String f()
    {
        return "nwvl";
    }

}
