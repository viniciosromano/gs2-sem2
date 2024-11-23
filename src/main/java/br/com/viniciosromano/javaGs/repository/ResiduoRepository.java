package br.com.viniciosromano.javaGs.repository;

import br.com.viniciosromano.javaGs.model.Residuo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResiduoRepository extends JpaRepository<Residuo, Long> {
    Optional<Residuo> findByNome(String nome);
}