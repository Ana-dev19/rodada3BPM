package model;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TurmaTest {
    private Turma turma;
    private Pessoa pessoa1;
    private Pessoa pessoa2;

    @Before
    public void setUp() throws Exception {
        turma = new Turma();
        pessoa1 = new Pessoa(1, "Fulano");
        pessoa2 = new Pessoa(2, "Beltrano");
    }

    @Test
    public void testAdicionarPessoa() throws Exception {
        turma.adicionarPessoa(pessoa1);
        turma.adicionarPessoa(pessoa2);

        assertEquals(2, turma.getPessoas().size());
    }

    @Test
    public void testAdicionarPessoaComIdRepetido() throws Exception {
        turma.adicionarPessoa(pessoa1);
        try {
            turma.adicionarPessoa(pessoa1);
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Objeto pessoa já está atribuído à turma", e.getMessage());
        }
    }

    @Test
    public void testAdicionarPessoaInvalida() {
        Pessoa pessoaInvalida = new Pessoa();
        try {
            turma.adicionarPessoa(pessoaInvalida);
            fail("Expected an Exception to be thrown");
        } catch (Exception e) {
            assertEquals("Objeto pessoa inválido", e.getMessage());
        }
    }

    @Test
    public void testRemoverTodasPessoas() throws Exception {
        turma.adicionarPessoa(pessoa1);
        turma.adicionarPessoa(pessoa2);

        turma.removerTodasPessoas();

        assertEquals(0, turma.getPessoas().size());
    }
}

