package org.dt.perf.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PerfDataResponse {

    private String message;
    private Map<String, Map<String,String>> dataMap;
}
// Changed to String