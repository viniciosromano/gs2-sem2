package br.com.viniciosromano.javaGs.dtos;

import br.com.viniciosromano.javaGs.model.enums.UnidadeMedida;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResiduoResponseDto {
    private Long id;
    private String nome;
    private String tipo;
    private Double quantidade;
    private UnidadeMedida unidade;
    private LocalDateTime dataRecebimento;

}
