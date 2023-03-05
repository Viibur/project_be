package com.example.projectbe.service;

import com.example.projectbe.model.Veanaide;
import com.example.projectbe.model.VeanaideDTO;
import com.example.projectbe.model.repository.VeanaideRepository;
import com.example.projectbe.service.mapper.VeanaideMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Slf4j
@Service
@AllArgsConstructor
public class VeaLugerService {

    private final VeanaideRepository veanaideRepository;
    private final VeanaideMapper veanaideMapper;

    public List<Veanaide> loeVeanaited() {
        List<VeanaideDTO> veanaideDTOList = new ArrayList<>();
        try {
            File file = new File(".\\project-be\\filtreeritud-eemaldatud.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String rida = scanner.nextLine();
                String[] tykid = rida.split(" - ");

                String vead = tykid[2];
                vead = vead.substring(0, vead.length() - 1);
                String[] vigadeList = vead.split("], \\[");
                Arrays.asList(vigadeList).forEach(viga -> {
                    viga = viga.replaceAll("\\[", "").replaceAll("]", "").replaceAll("'", "");
                    VeanaideDTO veanaideDTO = new VeanaideDTO();
                    veanaideDTO.setKorrektne(tykid[0]);
                    veanaideDTO.setViga(tykid[1]);
                    veanaideDTO.setLause(viga);
                    veanaideDTOList.add(veanaideDTO);
                });
            }
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        }
        veanaideRepository.deleteAll();
        return veanaideRepository.saveAll(veanaideMapper.toEntityList(veanaideDTOList));
    }
}
