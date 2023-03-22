package com.example.projectbe.controller;

import com.example.projectbe.model.VeanaideDTO;
import com.example.projectbe.service.AndmedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AndmedController {
    private final AndmedService andmedService;

    @GetMapping(value = "/andmed")
    public List<VeanaideDTO> getAndmed() {
        return andmedService.getAndmed();
    }

    @PostMapping(value = "/muuda_andmed")
    public void muudaAndmed(@RequestBody List<VeanaideDTO> veanaideDTOList) {
        andmedService.muudaAndmed(veanaideDTOList);
    }

    @GetMapping(value = "/paarid")
    public Map<String, String> getVigaKorrektnePaar() {
        return andmedService.getVigaKorrektnePaar();
    }
}
