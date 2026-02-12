package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuarioComArquivos {
    public static void main(String[] args) {

        RepositorioDeUsuarioEmArquivo repositorioDeUsuarioEmArquivo = new RepositorioDeUsuarioEmArquivo();

        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.456.789-00", "Ross",
                LocalDate.parse("2000-10-15"), "ross@gmail.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.456.789-00", "Max",
                LocalDate.parse("2004-10-15"), "max@gmail.com"));
        repositorioDeUsuarioEmArquivo.cadastrarUsuario(new Usuario("123.456.789-00", "Don",
                LocalDate.parse("2004-10-15"), "don@gmail.com"));

//        System.out.println(repositorioDeUsuarioEmArquivo.listarTodos());
        repositorioDeUsuarioEmArquivo.gravaEmArquivo("usuarios.txt");
    }
}
