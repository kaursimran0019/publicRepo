package org.dt.perf.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfData {

    private int id;
    private  int metaId; //perfid
    private String name;
    //    private Date creationDate;
    private int MinResp;
    private  int MaxResp;
    private int AvgResp;



}
