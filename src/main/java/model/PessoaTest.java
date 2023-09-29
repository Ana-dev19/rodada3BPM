package model;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

    public class PessoaTest {
        private Pessoa pessoa;

        @Before
        public void setUp() {
            pessoa = new Pessoa(1, "Fulano");
        }

        @Test
        public void testConstrutor() {
            assertEquals(1, pessoa.getId());
            assertEquals("Fulano", pessoa.getNome());
        }

        @Test
        public void testValidoComDadosValidos() {
            assertTrue(pessoa.valido());
        }

        @Test
        public void testValidoComIDZero() {
            pessoa.setId(0);
            assertFalse(pessoa.valido());
        }

        @Test
        public void testValidoComNomeVazio() {
            pessoa.setNome("");
            assertFalse(pessoa.valido());
        }

        @Test
        public void testValidoComDadosNulos() {
            Pessoa pessoaNula = new Pessoa(0, null);
            assertFalse(pessoaNula.valido());
        }
    }
