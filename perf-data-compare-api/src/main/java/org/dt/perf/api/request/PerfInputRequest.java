package org.dt.perf.api.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PerfInputRequest {

    private String perfId1;
    private String perfId2;
    private List<String> apiList;
}
