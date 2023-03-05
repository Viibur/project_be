package com.example.projectbe.controller;

import com.example.projectbe.model.VeanaideDTO;
import com.example.projectbe.service.VeanaideService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class VeanaideController {
    private final VeanaideService veanaideService;

    @GetMapping(value = "/naited")
    public List<VeanaideDTO> getVeanaited() {
        return veanaideService.getVeanaited();
    }

    @PostMapping(value = "/uuenda_naited")
    public void uuendaNaited(@RequestBody List<VeanaideDTO> veanaideDTOList) {
        veanaideService.uuendaNaide(veanaideDTOList);
    }

    @GetMapping(value = "/paarid")
    public Map<String, String> getVigaKorrektnePaar() {
        return veanaideService.getVigaKorrektnePaar();
    }
}
