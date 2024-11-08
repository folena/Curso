/*
 * package com.Curso.Curso.test;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertTrue;
 * 
 * import org.junit.jupiter.api.BeforeEach; import org.junit.jupiter.api.Test;
 * 
 * import com.Curso.Curso.entity.Aluno;
 * 
 * public class CursoTest {
 * 
 * private Aluno aluno;
 * 
 * @BeforeEach public void setUp() { // Inicializando o objeto aluno antes de
 * cada teste aluno = new Aluno(); }
 * 
 * @Test public void alunoDeveReceber3CursosSeNotaMaiorQue7() {
 * aluno.setNota(7.5); int cursosAdicionais = aluno.calcularCursosAdicionais();
 * assertEquals(3, cursosAdicionais,
 * "Aluno deveria receber 3 cursos adicionais."); }
 * 
 * @Test public void alunoDeveReceberCursoAdicionalSeForMaisAtivoNoForum() { //
 * Simulando que o aluno participou e foi o mais ativo no fórum
 * aluno.setContribuicoesUteisNoForum(15); // Exemplo: 15 contribuições
 * aluno.setMaisContribuicoesNoForum(true); // Indicando que ele foi o mais
 * ativo
 * 
 * // Verificando se o aluno recebe um curso adicional boolean
 * ganhouCursoAdicional = aluno.verificarSeGanhouCursoAdicional();
 * assertTrue(ganhouCursoAdicional,
 * "O aluno deveria receber um curso adicional."); }
 * 
 * @Test public void alunoDeveSerPromovidoParaPremiumApos12Cursos() { //
 * Simulando que o aluno completou 12 cursos aluno.setCursosConcluidos(12);
 * aluno.setPremium(false); // No começo, o aluno não é Premium
 * 
 * // Verificando se o aluno foi promovido para Premium
 * aluno.verificarStatusPremium(); assertTrue(aluno.isPremium(),
 * "O aluno deveria ser promovido para Premium após completar 12 cursos."); }
 * 
 * @Test public void alunoDeveReceberVoucherAoSeTornarPremium() { //
 * Inicialmente, o aluno não tem o status Premium e não possui voucher
 * aluno.setPremium(false); aluno.setTemVoucher(false);
 * 
 * // Promovendo o aluno para Premium aluno.setPremium(true);
 * aluno.verificarRecebimentoDeVoucher();
 * 
 * // Verificando se o aluno recebeu o voucher assertTrue(aluno.isTemVoucher(),
 * "O aluno deveria receber um voucher ao se tornar Premium."); } }
 */