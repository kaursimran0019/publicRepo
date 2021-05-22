package org.dt.perf.adapter.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Entity
@Setter

public class PerfData {

    @Id
    private int id;
    private  int metaId;
    private Date creationDate;
    private int MinResp;
    private  int MaxResp;
    private int AvgResp;
}

/*

    swap(a,b)
    metadata id
    idx
    date created
    url
    min resp time
    max resp time
    avg resp time
 */