package br.com.alura.codechella.domain.evento;

import br.com.alura.codechella.domain.ingresso.TipoIngresso;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Evento {

    private UUID uuid;
    private Categoria categoria;
    private String descricao;
    private LocalDateTime data;
    private Endereco endereco;
    private List<TipoIngresso> tipoIngressos;

    private Evento() {
        // Construtor privado para garantir a construção apenas através do Builder
    }

    public static class Builder {
        private Evento evento;

        public Builder() {
            evento = new Evento();
        }

        public Builder comCategoria(Categoria categoria) {
            evento.categoria = categoria;
            return this;
        }

        public Builder comDescricao(String descricao) {
            evento.descricao = descricao;
            return this;
        }

        public Builder comEndereco(String cep, Integer numero, String complemento) {
            Endereco endereco = new Endereco(cep, numero, complemento);
            evento.endereco = endereco;
            return this;
        }

        public Builder comData(LocalDateTime data) {
            evento.data = data;
            return this;
        }

        public Evento build() {
            evento.gerarIdentificadorUnico();
            return evento;
        }
    }

    private void gerarIdentificadorUnico() {
        this.uuid = UUID.randomUUID();
    }

    public void incluiNovoTipoDeIngressoAoEvento(TipoIngresso tipoIngresso){
        this.tipoIngressos.add(tipoIngresso);
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public List<TipoIngresso> getTipoIngressos() {
        return tipoIngressos;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "uuid=" + uuid +
                ", categoria=" + categoria +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                ", endereco=" + endereco +
                ", tipoIngressos=" + tipoIngressos +
                '}';
    }
}
