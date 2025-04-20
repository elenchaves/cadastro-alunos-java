import com.antonia.treinando.Aluno;
import com.antonia.treinando.SistemaCadastro;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Teste {

    @Test
    public void testCriacaoAluno() {
        Aluno aluno = new Aluno("Antonia", "12345", LocalDate.of(1992, 12, 7));

        assertNotNull(aluno);  // Garante que o aluno não seja nulo
        assertEquals("Antonia", aluno.getNome());  // Verifica o nome
        assertEquals("12345", aluno.getMatricula());  // Verifica a matrícula
        assertEquals(32, aluno.getIdade());  // Verifica se a idade está correta (isso pode mudar dependendo do ano atual)
    }

    @Test
    public void testAdicionarAluno() {
        SistemaCadastro cadastro = new SistemaCadastro();
        Aluno aluno = new Aluno("Antonia", "12345", LocalDate.of(1992, 12, 7));

        cadastro.adicionarAluno(aluno);

        assertEquals(1, cadastro.getAlunos().size());  // Verifica se o aluno foi adicionado à lista
        assertEquals(aluno, cadastro.getAlunos().get(0));  // Verifica se o aluno correto está na lista
    }
    @Test
    public void testRemoverAluno() {
        SistemaCadastro cadastro = new SistemaCadastro();
        Aluno aluno = new Aluno("Antonia", "12345", LocalDate.of(1992, 12, 7));
        cadastro.adicionarAluno(aluno);

        cadastro.removerAlunoPorMatricula("12345");  // Remover o aluno

        assertEquals(0, cadastro.getAlunos().size());  // Verifica se a lista de alunos está vazia
    }
}
