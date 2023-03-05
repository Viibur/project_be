package com.example.projectbe.service.mapper;

import com.example.projectbe.model.Veanaide;
import com.example.projectbe.model.VeanaideDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VeanaideMapper {

    VeanaideDTO toDTO(Veanaide veanaide);

    Veanaide toEntity(VeanaideDTO veanaideDTO);

    List<VeanaideDTO> toDTOList(List<Veanaide> veanaideList);

    List<Veanaide> toEntityList(List<VeanaideDTO> veanaideDTOList);
}
