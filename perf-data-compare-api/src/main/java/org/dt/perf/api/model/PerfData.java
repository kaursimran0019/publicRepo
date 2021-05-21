package org.dt.perf.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfData {

    private String id;
    private String metaDataId;
    private Date dateCreated;
    private String url;
    private int minResponseTime;
    private int maxResponseTime;
    private int avgResponseTime;



}
