package org.dt.perf.api.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class PerfDataResponse {

    private String message;
    private Map<String, Map<String,Integer>> dataMap;
}
