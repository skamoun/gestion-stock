package com.kamoun.gestiondestock.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@EntityListeners(AuditingEntityListener.class) // listen to @CreatedDate    @LastModifiedDate in order to update fields annotated with theses annotations
@MappedSuperclass
public class AbstractEntity implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;
    @CreatedDate
    @Column(name = "_creation_date",nullable = false)
    @JsonIgnore
    private LocalDate createDate;
    @LastModifiedDate
    @Column(name = "_last_modified_date")
    @JsonIgnore
    private LocalDate lastUpdateDate;
}

