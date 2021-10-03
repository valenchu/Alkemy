package com.icons.geographic.start.entity;

import java.util.ArrayList;
import java.util.List;

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
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
@SQLDelete(sql = "UPDATE ciudad_pais SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Table(name = "`ciudad_pais`")
public class CiudadPaisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    @JsonIgnore
    private Long id;
    @Column
    @NotEmpty
    @NotNull
    private String img;
    @Column
    @NotEmpty
    @NotNull
    private String denominacion;
    @Column(name = "cant_habitante")
    @NotNull
    @NotEmpty
    private Long cantHabitante;
    @Column
    private Boolean deleted = Boolean.FALSE;
    @Column
    @NotNull
    @NotEmpty
    private Float superficie;// m2
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "continente_id")
    private ContinenteEntity continente;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "iconn", joinColumns = @JoinColumn(name = "city_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "icon_id", referencedColumnName = "id"))
    private List<IconGeograficoEntity> icon = new ArrayList<>();

    public void addIcon(IconGeograficoEntity iconAdd) {
	this.icon.add(iconAdd);
    }
}
