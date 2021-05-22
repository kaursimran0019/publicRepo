package org.dt.perf.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerfInputRequest {

    private String perfId1;
    private String perfId2;
    private List<String> apiList;
}
