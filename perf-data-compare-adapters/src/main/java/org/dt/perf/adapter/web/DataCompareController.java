package org.dt.perf.adapter.web;

import lombok.AllArgsConstructor;
import org.dt.perf.api.model.PerfData;
import org.dt.perf.api.request.PerfInputRequest;
import org.dt.perf.api.response.PerfDataResponse;
import org.dt.perf.api.web.IdataCompareController;
import org.dt.perf.core.port.in.DataCompareServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/compare_app")
@AllArgsConstructor
public class DataCompareController implements IdataCompareController {

    @Autowired
    final DataCompareServicePort dataCompareServicePort;
    @Override
    @GetMapping(path = "/run")
    public PerfDataResponse getTheComparison(@RequestBody PerfInputRequest perfInputRequest) {
        try
        {
            return dataCompareServicePort.getComparisonData(perfInputRequest);
        }
        catch (Exception e)
        {
            return new PerfDataResponse("Enter a Valid API-List",null);
        }
    }

    @Override
    @GetMapping(path = "/dummy")
    public String f() {
        return "running";
    }


    @Override
    @GetMapping(path = "/showperf")
    public Object showAllPerf() {
        return  dataCompareServicePort.getAllPerf();
    }

    @Override
    @GetMapping(path = "/findByMetaId")
    public List<PerfData> FindByMetaId(@RequestParam Integer metaId) {
        return  dataCompareServicePort.findByMetaId(metaId);
    }

    @Override
    @GetMapping(path = "/findById")
    public Object FindById(Integer id){
        return dataCompareServicePort.findById(id);
    }
}
