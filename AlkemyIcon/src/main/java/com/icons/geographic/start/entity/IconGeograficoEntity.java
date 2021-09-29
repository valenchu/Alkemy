package com.icons.geographic.start.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "`incono_geografico`")
public class IconGeograficoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    @NotNull
    private String img;
    @Column
    @NotNull
    private String denominacion;
    @Column(name = "`fecha_de_creacion`")
    @NotNull
    @DateTimeFormat
    private LocalDate fechaCreacion;
    @Column
    @NotNull
    private Float altura;
    @Column
    @NotNull
    private String historia;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "city", joinColumns = @JoinColumn(name = "icon_id"), inverseJoinColumns = @JoinColumn(name = "city_id"))
    private Set<CiudadPaisEntity> city = new HashSet<CiudadPaisEntity>();
}
