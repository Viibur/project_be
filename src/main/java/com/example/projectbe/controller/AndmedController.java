package com.example.projectbe.controller;

import com.example.projectbe.model.VeanaideDTO;
import com.example.projectbe.service.AndmedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
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

    @GetMapping(value = "raporteeri/{id}")
    public void raporteeri(@PathVariable("id") int id) {
        andmedService.raporteeri(Integer.toUnsignedLong(id));
    }
}
