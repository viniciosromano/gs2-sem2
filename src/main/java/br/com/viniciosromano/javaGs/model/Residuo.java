package br.com.viniciosromano.javaGs.model;

import br.com.viniciosromano.javaGs.model.enums.UnidadeMedida;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Residuo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100,nullable = false)
    private String nome;

    @Column(length = 20,nullable = false)
    private String tipo;

    @Column(nullable = false)
    private Double quantidade;

    @Column(nullable = false, length = 2)
    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.CHAR)
    private UnidadeMedida unidade;

    @Column(nullable = false)
    private LocalDateTime dataRecebimento;

    @PrePersist
    public void dataRecebimentoDefault() {
        if (dataRecebimento==null){
            this.dataRecebimento = LocalDateTime.now();
        }
    }
}
