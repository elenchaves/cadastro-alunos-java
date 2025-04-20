package com.antonia.treinando;

import java.time.LocalDate;
import java.time.Period;

public class Aluno {
    private String nome;
    private String matricula;
    private LocalDate dataNascimento;

    public Aluno(String nome, String matricula, LocalDate nasc) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = nasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getdataNascimento() {
        return dataNascimento;
    }

    public void setdataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade(){
        return Period.between(dataNascimento,LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return String.format("DADOS DO ALUNO: | Matricula = %s | Nome = %s | Idade = %d",
                 getMatricula(), getNome(), getIdade());

    }
}
