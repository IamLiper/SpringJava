package com.example.AttPontuada1.service;

import com.example.AttPontuada1.model.Funcionario;
import com.example.AttPontuada1.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(@Valid Funcionario funcionario) {
        if (funcionarioRepository.findByEmail(funcionario.getEmail()).isPresent()) {
            throw new RuntimeException("Funcionário já cadastrado.");
        }

        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizar(@Valid Funcionario funcionario) {
        Funcionario funcionarioAtualizar = funcionarioRepository.findById(funcionario.getId())
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado."));

        funcionarioAtualizar.setNome(funcionario.getNome());
        funcionarioAtualizar.setCpf(funcionario.getCpf());
        funcionarioAtualizar.setDataNascimento(funcionario.getDataNascimento());
        funcionarioAtualizar.setSexo(funcionario.getSexo());
        funcionarioAtualizar.setSetor(funcionario.getSetor());
        funcionarioAtualizar.setEstadoCivil(funcionario.getEstadoCivil());
        funcionarioAtualizar.setSalario(funcionario.getSalario());
        funcionarioAtualizar.setEmail(funcionario.getEmail());
        funcionarioAtualizar.setEndereco(funcionario.getEndereco());

        return funcionarioRepository.save(funcionario);
    }

    public void excluir(String email) {
        Funcionario funcionario = funcionarioRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado."));

        funcionarioRepository.deleteById(funcionario.getId());
    }
}
