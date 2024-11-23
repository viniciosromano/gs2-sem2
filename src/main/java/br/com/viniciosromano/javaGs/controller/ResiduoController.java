package br.com.viniciosromano.javaGs.controller;

import br.com.viniciosromano.javaGs.dtos.ResiduoRequestCreateDto;
import br.com.viniciosromano.javaGs.dtos.ResiduoRequestUpdateDto;
import br.com.viniciosromano.javaGs.dtos.ResiduoResponseDto;
import br.com.viniciosromano.javaGs.mapper.ResiduoMapper;
import br.com.viniciosromano.javaGs.service.ResiduoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/residuos")
@RequiredArgsConstructor
public class ResiduoController {
    private final ResiduoMapper residuoMapper;
    private final ResiduoService residuoService;

    @GetMapping
    public ResponseEntity<List<ResiduoResponseDto>> list() {
        List<ResiduoResponseDto> dtos = residuoService.list()
                .stream()
                .map(residuoMapper::toDto)
                .toList();

        return ResponseEntity.ok().body(dtos);
    }
    @GetMapping("{id}")
    public ResponseEntity<ResiduoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok()
                .body(
                        residuoService
                                .findById(id)
                                .map(residuoMapper::toDto)
                                .orElseThrow(() -> new RuntimeException("Id inexistente"))
                );
    }
    @GetMapping("find/{nome}")
    public ResponseEntity<ResiduoResponseDto> findByNome(@RequestParam String nome) {
        return ResponseEntity.ok()
                .body(
                        residuoService
                                .findByNome(nome)
                                .map(residuoMapper::toDto)
                                .orElseThrow(() -> new RuntimeException("Nome inexistente"))
                );
    }

    @PostMapping
    public ResponseEntity<ResiduoResponseDto> create(@RequestBody ResiduoRequestCreateDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        residuoMapper.toDto(
                                residuoService.save(residuoMapper.toModel(dto))
                        )
                );
    }

    @PutMapping("{id}")
    public ResponseEntity<ResiduoResponseDto> update(
            @PathVariable Long id,
            @RequestBody ResiduoRequestUpdateDto dto) {
        if (residuoService.notExistsById(id)){
            throw new RuntimeException("Id inexistente");
        }
        return ResponseEntity.ok()
                .body(
                        residuoMapper.toDto(
                                residuoService.save(residuoMapper.toModel(id, dto))
                        )
                );
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        if (residuoService.notExistsById(id)){
            throw new RuntimeException("Id inexistente");
        }

        residuoService.delete(id);
    }
}
