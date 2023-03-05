package com.example.projectbe.controller;

import com.example.projectbe.model.Veanaide;
import com.example.projectbe.service.VeaLugerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UuedVeadController {
    private final VeaLugerService veaLugerService;

    @GetMapping(value = "/loe_vead")
    public List<Veanaide> getVead() {
        return veaLugerService.loeVeanaited();
    }
}
