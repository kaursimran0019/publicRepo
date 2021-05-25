package org.dt.perf.api.web;


import org.dt.perf.api.model.PerfData;
import org.dt.perf.api.request.PerfInputRequest;
import org.dt.perf.api.response.PerfDataResponse;


public interface IdataCompareController {

    PerfDataResponse getTheComparison(PerfInputRequest perfInputRequest);
    String f();
    Object showAllPerf();
    Object FindById(Integer id);
    Iterable<PerfData> FindByMetaId(Integer id);
}
