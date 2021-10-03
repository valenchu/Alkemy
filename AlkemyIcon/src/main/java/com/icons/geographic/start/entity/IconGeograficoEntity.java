package com.icons.geographic.start.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SQLDelete(sql = "UPDATE incono_geografico SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Table(name = "`incono_geografico`")
public class IconGeograficoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    @NotNull
    @NotEmpty
    private String img;
    @Column
    @NotNull
    @NotEmpty
    private String denominacion;
    @Column(name = "`fecha_de_creacion`")
    @NotNull
    @NotEmpty
    @DateTimeFormat
    private LocalDate fechaCreacion;
    @Column
    private Boolean deleted = Boolean.FALSE;
    @Column
    @NotNull
    @NotEmpty
    private Float altura;
    @Column
    @NotNull
    @NotEmpty
    private String historia;
    @JsonIgnore
    @ManyToMany(mappedBy = "icon")
    private List<CiudadPaisEntity> city = new ArrayList<>();
    
    public void addCity(CiudadPaisEntity cityAdd) {
	city.add(cityAdd);
    }
}
