package com.example.projectbe.service;

import com.example.projectbe.model.VeanaideDTO;
import com.example.projectbe.model.repository.VeanaideRepository;
import com.example.projectbe.service.mapper.VeanaideMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AndmedService {

    private final VeanaideRepository veanaideRepository;
    private final VeanaideMapper veanaideMapper;

    public List<VeanaideDTO> getAndmed() {
        return veanaideMapper.toDTOList(veanaideRepository.findAllByOrderBySagedusDesc());
    }

    public void muudaAndmed(List<VeanaideDTO> veanaideDTOList) {
        veanaideRepository.saveAll(veanaideMapper.toEntityList(veanaideDTOList));
    }

    public Map<String, String> getVigaKorrektnePaar() {
        List<VeanaideDTO> veanaited = getAndmed();
        Map<String, List<VeanaideDTO>> vigaVeanaideDTOListMap = veanaited.stream().collect(Collectors.groupingBy(VeanaideDTO::getViga));
        Map<String, String> vigaKorrektneMap = new HashMap<>();

        vigaVeanaideDTOListMap.keySet().forEach(viga -> {
            Map<String, Integer> korrektneMituMap = new HashMap<>();
            vigaVeanaideDTOListMap.get(viga).forEach(veanaideDTO -> {
                if (korrektneMituMap.containsKey(veanaideDTO.getKorrektne())) {
                    korrektneMituMap.put(veanaideDTO.getKorrektne(), korrektneMituMap.get(veanaideDTO.getKorrektne()) + 1);
                } else {
                    korrektneMituMap.put(veanaideDTO.getKorrektne(), 1);
                }
            });
            String suurim = "";
            Integer korgeim = 0;
            for (String korrektne : korrektneMituMap.keySet()) {
                if (korrektneMituMap.get(korrektne) > korgeim) {
                    korgeim = korrektneMituMap.get(korrektne);
                    suurim = korrektne;
                }
            }
            vigaKorrektneMap.put(viga, suurim);
        });
        return vigaKorrektneMap;
    }
}
