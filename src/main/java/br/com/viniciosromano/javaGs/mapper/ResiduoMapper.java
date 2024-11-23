package br.com.viniciosromano.javaGs.mapper;

import br.com.viniciosromano.javaGs.dtos.ResiduoRequestCreateDto;
import br.com.viniciosromano.javaGs.dtos.ResiduoRequestUpdateDto;
import br.com.viniciosromano.javaGs.dtos.ResiduoResponseDto;
import br.com.viniciosromano.javaGs.model.Residuo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResiduoMapper {

    private final ModelMapper modelMapper;

    public ResiduoResponseDto toDto(Residuo residuo) {
        return modelMapper.map(residuo, ResiduoResponseDto.class);
    }

    public Residuo toModel(ResiduoRequestCreateDto dto) {
        return modelMapper.map(dto, Residuo.class);
    }

    public Residuo toModel(Long id, ResiduoRequestUpdateDto dto) {
        Residuo result = modelMapper.map(dto, Residuo.class);
        result.setId(id);
        return result;
    }

}