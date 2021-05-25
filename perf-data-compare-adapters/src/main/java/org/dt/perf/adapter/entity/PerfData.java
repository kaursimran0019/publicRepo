package org.dt.perf.adapter.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Entity
@Setter
//@NamedNativeQuery(name="PerfData.findByMetaId", query="SELECT P1.NAME, P1.MAXRESP-P2.MAXRESP AS MAXDIF,P1.MINRESP-P2.MINRESP AS MINDIF, P1.AVGRESP-P2.AVGRESP AS AVGDAIF FROM PERFDATA AS P1,PERFDATA AS P2 WHERE P1.NAME=P2.NAME AND P1.METAID=? AND P2.METAID=? AND P1.NAME IN ('API1','API2');",resultClass = PerfData.class)
//Changes Required
public class PerfData {

    @Id
    private int id;
    private  int metaId; //perfid
    private String name;
//    private Date creationDate;
    private int MinResp;
    private  int MaxResp;
    private int AvgResp;
}
/*
SELECT P1.NAME, P1.MAXRESP-P2.MAXRESP AS MAXDIF,P1.MINRESP-P2.MINRESP AS MINDIF,P1.MAXRESP-P2.MAXRESP AS MAXDIF FROM PERFDATA AS P1,PERFDATA AS P2 WHERE P1.NAME=P2.NAME AND P1.METAID=1 AND P2.METAID=2;

 */