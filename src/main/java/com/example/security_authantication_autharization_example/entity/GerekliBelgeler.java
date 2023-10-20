package com.example.security_authantication_autharization_example.entity;

import com.example.security_authantication_autharization_example.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gerekli_belgeler")
public class GerekliBelgeler extends BaseEntity {

    @Column(name = "belge")
    private String belge;

    @Column(name = "ulke")
    private String ulke;

}
