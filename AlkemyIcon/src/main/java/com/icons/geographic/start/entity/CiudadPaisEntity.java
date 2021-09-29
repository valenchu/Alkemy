package com.icons.geographic.start.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "`ciudad_pais`")
public class CiudadPaisEntity {
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
    @Column(name = "cant_habitante")
    @NotNull
    private Long cantHabitante;
    @Column
    @NotNull
    private Float superficie;// m2
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "continente_id")
    private ContinenteEntity continente;
    @ManyToMany(mappedBy = "city")
    private Set<IconGeograficoEntity> icon = new HashSet<IconGeograficoEntity>();

}
