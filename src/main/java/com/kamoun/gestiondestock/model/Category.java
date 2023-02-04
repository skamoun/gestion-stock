package com.kamoun.gestiondestock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.AbstractCollection;
import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category")
public class Category extends AbstractEntity{
    @Column(name = "_code")
    private String code;
    @Column(name = "_designation")
    private String designation;

    @OneToMany(mappedBy = "category")
    private  Collection<Article> articles;
}
