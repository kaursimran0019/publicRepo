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
//Changes Required
public class PerfData {

    @Id
    private int id;
    private  int metaId; //perfid
    private String name;
    private Date creationDate;
    private int MinResp;
    private  int MaxResp;
    private int AvgResp;
}
