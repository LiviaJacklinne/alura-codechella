package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class UsuarioTest {

    @Test
    public void naoDeveCriarUsuarioComCpfInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario(
                        "12345678900",
                        "Livia",
                        LocalDate.parse("2002-05-10"),
                        "livia@gmail.com")
        );
    }

    @Test
    public void deveCriarUsuarioFabricaDeUsuario() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento(
                "Ross",
                "123.456.789-00",
                LocalDate.parse("2002-05-10")
        );

        Assertions.assertEquals( "Ross", usuario.getNome());

        usuario = fabrica.incluiEndereco("12345-678", 123, "Casa");
        Assertions.assertEquals("Casa", usuario.getEndereco().getComplemento());
    }

    @Test
    public void naoDeveCadastrarUsuarioComMenosDe18anos() {

        // Crio uma data de nascimento que subtrai 17 anos da data atual
        LocalDate dataNascimento = LocalDate.now().minusYears(17);  // Um usuário com 17 anos

        // Crio uma exceção e atribuo a ela o resultado do teste de idade mínima, pois o correto é que a exceção seja lançada.
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("123.456.789-00", "Fulano", dataNascimento, "fulano@example.com");
        });

        // Confiro se a mensagem da exceção é a mensagem que eu esperava, referente à idade inferior
        Assertions.assertEquals("Usuário deve ter pelo menos 18 anos de idade!", exception.getMessage());
    }
}