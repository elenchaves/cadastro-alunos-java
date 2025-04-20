package com.antonia.treinando;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private SistemaCadastro cadastro = new SistemaCadastro();
    private Scanner sc = new Scanner(System.in);


    public void exibir(){
        int opcao;
        do {
            System.out.println("O que deseja fazer?");
            System.out.println("Cadastrar aluno [1] | Listar alunos [2] | Remover aluno [3] | Sair [0] : ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    adicionarAluno();
                    break;
                case 2:
                    cadastro.listarAlunos();
                    break;
                case 3:
                    removerAluno();
                    break;
                case 0:
                    System.out.println("Desconectando...");
                    break;
                default:
                    System.out.println("Opção inválida.");

            }
        }while (opcao != 0);
    }
    public void adicionarAluno() {
        String continuarCadastro;
        do {
            System.out.println("Adicione o nome do Aluno: ");
            String nome = sc.nextLine();
            System.out.println("Adicione a matricula: ");
            String matricula = sc.nextLine();
            System.out.println("Adicione a data de nascimento do aluno (dd-MM-yyyy): ");
            String dataNascimento = sc.nextLine();

            try {
                LocalDate nascimento = LocalDate.parse(dataNascimento, FORMATO_DATA);

                if (nascimento.isAfter(LocalDate.now())) {
                    System.out.println("ERRO: A data de nascimento não pode ser no futuro.");
                } else {
                    Aluno aluno = new Aluno(nome, matricula, nascimento);
                    cadastro.adicionarAluno(aluno);
                }
            } catch (Exception e) {
                System.out.println("Data inválida! Use o formato dd-MM-yyyy.");
            }

            System.out.println("Deseja adicionar mais alunos? [sim] [não]");
            continuarCadastro = sc.nextLine();
        } while (!continuarCadastro.equalsIgnoreCase("não"));
    }


    public void removerAluno(){
        System.out.println("Digite a matricula do aluno que deseja remover: ");
        String matricula = sc.nextLine();
        cadastro.removerAlunoPorMatricula(matricula);
    }
}
