package com.icons.geographic.start.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "`continente`")
public class ContinenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column
    @NotNull
    private String img;
    @Column
    @NotNull
    private String denominacion;
    @OneToMany(mappedBy = "continente")
    private Set<CiudadPaisEntity> ciudad;
}
