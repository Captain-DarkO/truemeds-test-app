package com.truemeds.testanurag.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "anurag_khadatkar_java_output")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdOn"})
final public class ReduceResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "processed_data")
    String processedData;

    long count;

    String processedBy;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdOn;

    public ReduceResult() {}

    public ReduceResult(final String processedData, final long count, final String processedBy) {
        this.processedData = processedData;
        this.count = count;
        this.processedBy = processedBy;
    }

    public String getProcessedData() {
        return processedData;
    }

    public long getCount() {
        return count;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedOn() {
        return createdOn;
    }
}
