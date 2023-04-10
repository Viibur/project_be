package com.example.projectbe.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VeanaideDTO {
    private Long id;
    private String korrektne;
    private String viga;
    private String lause;
    private int sagedus;
    private boolean raporteeritud;
}
