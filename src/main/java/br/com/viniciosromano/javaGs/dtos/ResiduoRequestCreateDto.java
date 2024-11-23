package br.com.viniciosromano.javaGs.dtos;

import br.com.viniciosromano.javaGs.model.enums.UnidadeMedida;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResiduoRequestCreateDto {
    private String nome;
    private String tipo;
    private Double quantidade;
    private UnidadeMedida unidade;
    private LocalDateTime dataRecebimento;

}
