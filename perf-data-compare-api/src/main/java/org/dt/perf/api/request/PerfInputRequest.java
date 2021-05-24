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

//    @NotBlank(message="perf1Id cannot be null")
    private String perfId1;
//    @NotBlank(message="perf2Id cannot be null")
    private String perfId2;
//    @NotEmpty(message="perf1Id cannot be null")
    private List<String> apiList;
}
