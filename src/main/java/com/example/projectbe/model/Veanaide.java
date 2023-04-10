package com.example.projectbe.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(schema = "public")
public class Veanaide {
    @Id
    @Column(insertable = false, updatable = false, unique = true)
    @SequenceGenerator(name = "veanaide_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veanaide_seq")
    private Long id;
    private String korrektne;
    private String viga;
    private String lause;
    private int sagedus;
    private boolean raporteeritud;
}
