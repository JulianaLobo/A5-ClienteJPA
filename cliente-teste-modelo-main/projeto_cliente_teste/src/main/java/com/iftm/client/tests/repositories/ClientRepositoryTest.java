package com.iftm.client.tests.repositories;
import static org.junit.jupiter.api.Assertions.*;

import com.iftm.client.entities.Client;
import com.iftm.client.repositories.ClientRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.assertj.core.api.Assertions;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@DataJpaTest
class ClientRepositoryTest {
    @Autowired
    private ClientRepository repository;

    @Test
    @DisplayName("Teste de busca por nome")
    void findByName() {
        String nomeBuscado = "Conceição Evaristo";

        Client client = repository.findByName("Conceição Evaristo");

        assertEquals(nomeBuscado,  client.getName());
    }

    @Test
    @DisplayName("Teste de busca por nomes")
    void findByListName() {
        int quant = 4;
        String nomes[] = {"Conceição Evaristo", "Clarice Lispector", "Carolina Maria de Jesus", "Chimamanda Adichie"};

        List<Client> resultado = repository.findByListName("c");

        Assertions.assertThat(resultado).isNotEmpty();
        Assertions.assertThat(resultado.size()).isEqualTo(quant);
        Assertions.assertThat(resultado.get(0).getName()).isEqualTo(nomes[0]);
        Assertions.assertThat(resultado.get(1).getName()).isEqualTo(nomes[1]);
        Assertions.assertThat(resultado.get(2).getName()).isEqualTo(nomes[2]);
        Assertions.assertThat(resultado.get(3).getName()).isEqualTo(nomes[3]);
    }

    @Test
    @DisplayName("Teste de busca por renda maior que")
    void findByIncomeGreaterThan() {
        double income = 4500;
        int quant  = 3;
        String names[] = {"Carolina Maria de Jesus", "Jose Saramago", "Toni Morrison"};

        List<Client> resultado = repository.findByIncomeGreaterThan(income);

        Assertions.assertThat(resultado).isNotEmpty();
        Assertions.assertThat(resultado.size()).isEqualTo(quant);
        Assertions.assertThat(resultado.get(0).getName()).isEqualTo(names[0]);
        Assertions.assertThat(resultado.get(1).getName()).isEqualTo(names[1]);
        Assertions.assertThat(resultado.get(2).getName()).isEqualTo(names[2]);
    }

    @Test
    @DisplayName("Teste de busca por renda menor que")
    void findByIncomeLessThan() {
        double income = 4500;
        int quant  = 7;
        String names [] = {"Conceição Evaristo", "Lázaro Ramos", "Clarice Lispector"};

        List<Client> resultado = repository.findByIncomeLessThan(income);

        Assertions.assertThat(resultado).isNotEmpty();
        Assertions.assertThat(resultado.size()).isEqualTo(quant);
        Assertions.assertThat(resultado.get(0).getName()).isEqualTo(names[0]);
        Assertions.assertThat(resultado.get(1).getName()).isEqualTo(names[1]);
        Assertions.assertThat(resultado.get(2).getName()).isEqualTo(names[2]);
    }

    @Test
    @DisplayName("Teste de busca por renda entre")
    void findByIncomeBetween() {
        double valor_inicio = 3000;
        double valor_final = 5000;
        int quant  = 4;
        String names[] = {"Clarice Lispector", "Djamila Ribeiro", "Jose Saramago","Silvio Almeida"};

        List<Client> resultado = repository.findByIncomeBetween(valor_inicio, valor_final);

        Assertions.assertThat(resultado).isNotEmpty();
        Assertions.assertThat(resultado.size()).isEqualTo(quant);
        Assertions.assertThat(resultado.get(0).getName()).isEqualTo(names[0]);
        Assertions.assertThat(resultado.get(1).getName()).isEqualTo(names[1]);
        Assertions.assertThat(resultado.get(2).getName()).isEqualTo(names[2]);
        Assertions.assertThat(resultado.get(3).getName()).isEqualTo(names[3]);
    }

    @Test
    @DisplayName("Teste de busca por data de nascimento superior e inferior")
    void findByBirthDateBetween() {
        Instant data_inicio = Instant.parse("1918-09-23T07:00:00Z");
        Instant data_final = Instant.parse("1960-04-13T07:50:00Z");
        int quant = 6;
        String names[] = {"Clarice Lispector", "Gilberto Gil","Toni Morrison", "Yuval Noah Harari", "Chimamanda Adichie", "Jorge Amado"};

        List<Client> resultado = repository.findByBirthDateBetween(data_inicio, data_final);

        Assertions.assertThat(resultado).isNotEmpty();
        Assertions.assertThat(resultado.size()).isEqualTo(quant);
        Assertions.assertThat(resultado.get(0).getName()).isEqualTo(names[0]);
        Assertions.assertThat(resultado.get(1).getName()).isEqualTo(names[1]);
        Assertions.assertThat(resultado.get(2).getName()).isEqualTo(names[2]);
        Assertions.assertThat(resultado.get(3).getName()).isEqualTo(names[3]);
        Assertions.assertThat(resultado.get(4).getName()).isEqualTo(names[4]);
        Assertions.assertThat(resultado.get(5).getName()).isEqualTo(names[5]);

    }
}

