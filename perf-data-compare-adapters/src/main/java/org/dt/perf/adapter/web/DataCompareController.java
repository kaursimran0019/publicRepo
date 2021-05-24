package org.dt.perf.adapter.web;

import lombok.AllArgsConstructor;
import org.dt.perf.api.request.PerfInputRequest;
import org.dt.perf.api.response.PerfDataResponse;
import org.dt.perf.api.web.IdataCompareController;
import org.dt.perf.core.port.in.DataCompareServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/demo")
@AllArgsConstructor
public class DataCompareController implements IdataCompareController {

    @Autowired
    final DataCompareServicePort dataCompareServicePort;
    @Override
    @GetMapping(path = "/test")
    public PerfDataResponse getTheComparison(@RequestBody PerfInputRequest perfInputRequest) {
        return dataCompareServicePort.getComparisonData(perfInputRequest);
    }

    @Override
    @GetMapping(path = "/po")
    public String f() {
        return "nwvl";
    }

    @Override
    @GetMapping(path = "/showperf")
    public Object showAllPerf() {
        return  dataCompareServicePort.getAllPerf();
    }

    @Override
    @GetMapping(path = "/findByMetaId")
    public Object FindByMetaId(@RequestParam Integer metaId) {
        return  dataCompareServicePort.findByMetaId(metaId);
    }

    @Override
    @GetMapping(path = "/findById")
    public Object FindById(Integer id){
        return dataCompareServicePort.findById(id);
    }
}
