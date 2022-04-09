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
public class Approvisionnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int qteAppro;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate dateAppro;
    @ManyToOne
    @JoinColumn(name = "articleId", insertable = false, updatable = false)
    private Article article;
    private int articleId;
}
