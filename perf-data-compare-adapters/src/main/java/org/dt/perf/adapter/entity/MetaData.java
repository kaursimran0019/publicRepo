package org.dt.perf.adapter.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Changes Required

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Entity
@Setter
public class MetaData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
}
