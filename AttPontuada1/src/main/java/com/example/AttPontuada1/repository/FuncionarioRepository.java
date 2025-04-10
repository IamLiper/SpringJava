package com.example.AttPontuada1.repository;

import com.example.AttPontuada1.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Importando o repositório muito importante n sei pra que mas é.
@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    // Adicionando o Optional para eu poder excluir usando o email.
    Optional<Funcionario> findByEmail(String email);
}
