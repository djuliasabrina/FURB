# Exercício de Herança Bancária

## 📚 Sobre a atividade

Este projeto foi desenvolvido para a disciplina de **Programação Orientada a Objetos**, da Universidade Regional de Blumenau (FURB).

O objetivo da atividade é praticar os conceitos de **herança, encapsulamento, sobrescrita de métodos, tratamento de exceções e testes automatizados** utilizando a linguagem Java.

## 🎯 Objetivos

- Implementar classes utilizando herança.
- Desenvolver uma estrutura de contas bancárias.
- Aplicar modificadores de acesso, como `protected`.
- Sobrescrever métodos para especializar o comportamento de uma classe.
- Criar testes automatizados para validar as funcionalidades.
- Registrar o histórico de depósitos e saques realizados em uma conta bancária.

## 🏦 Questões desenvolvidas

### Questão 1 — Herança bancária

Implementação das classes `ContaBancaria`, `ContaEspecial` e `Cliente`.

A classe `ContaEspecial` permite realizar saques utilizando um limite de crédito, inclusive quando o valor do saque é superior ao saldo disponível, respeitando o limite estabelecido.

O método `sacar()` é sobrescrito na subclasse para implementar essa regra.

### Questão 2 — Testes da ContaEspecial

Implementação de testes para verificar o funcionamento do método `sacar()`:

- Permitir saques superiores ao saldo, respeitando o limite de crédito.
- Permitir saques até o limite disponível.
- Lançar uma `RuntimeException` quando o saque ultrapassar o saldo e o limite de crédito.

### Questão 3 — Histórico de movimentações

Implementação da classe `Movimento` para registrar as operações realizadas na conta bancária.

Cada movimentação armazena o tipo de operação, o valor e a data e hora em que ocorreu.

Os depósitos e saques devem gerar registros no histórico da conta, utilizando as classes `LocalDate` e `LocalTime` da API Java.

### Questão 4 — Testes do histórico de movimentações

Integração da classe `ContaEspecial` ao projeto com histórico de movimentações.

Criação de testes para verificar se os depósitos e saques geram os movimentos corretos, incluindo o tipo de operação e o valor registrado.

## 🛠️ Tecnologias utilizadas

- **Java** — linguagem de programação.
- **Programação Orientada a Objetos (POO)** — conceitos de herança, encapsulamento e sobrescrita.
- **JUnit** — testes automatizados.
- **Java Time API** — manipulação de datas e horários.

## 📌 Conceitos praticados

- Herança entre classes.
- Reutilização de código.
- Sobrescrita de métodos (`@Override`).
- Modificadores de acesso (`protected`).
- Tratamento de exceções.
- Coleções para armazenar movimentações.
- Testes unitários.
- Registro de operações bancárias.

## 👩‍💻 Autoria

**Djúlia Sabrina Preti**

Curso: Ciência da Computação — FURB  
Disciplina: Programação Orientada a Objetos

