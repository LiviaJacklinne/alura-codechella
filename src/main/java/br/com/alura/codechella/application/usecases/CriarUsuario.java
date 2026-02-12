package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class CriarUsuario {

    private final RepositorioDeUsuario repository;

    public CriarUsuario(RepositorioDeUsuario repository) {
        this.repository = repository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return repository.cadastrarUsuario(usuario);
    }
}
