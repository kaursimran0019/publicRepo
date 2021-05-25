package org.dt.perf.api.request;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor

public class PerfInputRequest {

//    @NotNull(message = "PerID cannot be NULL")
    private String perfId1;
//    @NotNull(message = "PerfID cannot be NULL")
    private String perfId2;
//    @NotNull(message = "ApiList cannot be NULL")
    private List<String> apiList;

    public PerfInputRequest(String perfId1,String perfId2, Object apiList)
    {
        try
        {
            this.setPerfId1((String) perfId1);
            this.setPerfId2((String) perfId2);
            this.setApiList((List<String>) apiList);
        }
        catch(Exception e)
        {
            this.setPerfId1((String) perfId1);
            this.setPerfId2((String) perfId2);
            this.setApiList(null);
        }
    }
}
