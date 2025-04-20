package com.antonia.treinando;

import java.util.ArrayList;
import java.util.List;

public class SistemaCadastro {
    private ArrayList<Aluno> alunos = new ArrayList<>();

    //Metodo para adicionar alunos ao ArrayList
    public void adicionarAluno(Aluno aluno){

        //Varre a o array para saber se o aluno já esta cadastrado no sistema.
        boolean existe = false;
        for (Aluno a: alunos) {
            if(a.getMatricula().equals(aluno.getMatricula())) {
                existe = true;
                break;
            }
        }
        //Caso não esteja na lista, o mesmo é adicionado
        if(!existe){
            alunos.add(aluno);
            System.out.println("Aluno adicionado com sucesso!");
        }else{
            System.out.println("Aluno já cadastrado!");
        }
    }

    public void listarAlunos(){
        //Verifica se há alunos na lista, caso não haja é exibido essa informação.
        if(alunos.isEmpty()){
            System.out.println("Não tem alunos cadastrados!");
        }else {
            for (Aluno aluno : alunos) {
                System.out.println(aluno.toString());
            }
        }
    }

    public void removerAlunoPorMatricula(String matricula){
        boolean removido = false;
        for (int i = 0; i < alunos.size(); i++){
            if(alunos.get(i).getMatricula().equals(matricula)){ //verifica se nº de matricula esta na lista.
                alunos.remove(i);
                removido = true;
                break;//para não continuar procurando
            }
        }
        if (removido) {
            System.out.println("Aluno removido com sucesso!");
        }else {
            System.out.println("Aluno da matricula " +matricula + " não encontrado.");

        }
    }
    // Metodo para acessar a lista de alunos
    public List<Aluno> getAlunos() {
        return alunos;
    }
}
