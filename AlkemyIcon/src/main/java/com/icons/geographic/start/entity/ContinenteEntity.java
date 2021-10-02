package com.icons.geographic.start.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
@SQLDelete(sql = "UPDATE continente SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Table(name = "`continente`")
public class ContinenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    @NotEmpty
    private Long id;
    @Column
    @NotEmpty
    @NotNull
    private String img;
    @Column
    @NotEmpty
    @NotNull
    private String denominacion;
    @Column
    private Boolean deleted = Boolean.FALSE;
    @OneToMany(mappedBy = "continente", fetch = FetchType.EAGER)
    private List<CiudadPaisEntity> ciudad;
}
