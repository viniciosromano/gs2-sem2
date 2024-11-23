package br.com.viniciosromano.javaGs.service;

import br.com.viniciosromano.javaGs.model.Residuo;
import br.com.viniciosromano.javaGs.repository.ResiduoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResiduoService {
    private final ResiduoRepository residuoRepository;

    public List<Residuo> list() {
        return residuoRepository.findAll();
    }

    @Transactional
    public Residuo save(Residuo residuo) {
        return residuoRepository.save(residuo);
    }

    public boolean notExistsById(Long id) {
        return !residuoRepository.existsById(id);
    }

    public void delete(Long id) {
        residuoRepository.deleteById(id);
    }

    public Optional<Residuo> findById(Long id) {
        return residuoRepository.findById(id);
    }

    public Optional<Residuo> findByNome(String nome) {
        return residuoRepository.findByNome(nome);

    }
}
