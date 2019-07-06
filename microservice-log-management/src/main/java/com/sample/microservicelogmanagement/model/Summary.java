package com.sample.microservicelogmanagement.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Table("summary")
public class Summary implements Serializable {

    @PrimaryKeyColumn(name="course_id", type = PrimaryKeyType.PARTITIONED)
    private Long courseId;

    @PrimaryKeyColumn(name="hit_count", type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING )
    private Long hitCount;
}
