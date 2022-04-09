package com.defi.tp_vente.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateVente;
    private int qteVente;
    @ManyToOne
    @JoinColumn(name= "articleId",insertable = false, updatable = false)
    private Article article;
    private int articleId;
}