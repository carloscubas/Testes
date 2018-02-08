package br.banco.teste;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import br.banco.builder.ContaBuilder;
import br.banco.dao.ContaDao;
import br.banco.dominio.Banco;
import br.banco.dominio.Conta;
import br.banco.dominio.Usuario;

public class BancoTest {

	private Conta c1;
	private Conta c2;
	private Usuario joao;
	private Usuario manoel;

	@Before
	public void criarAmbiente() {
		c1 = new Conta(100.0, "Basica");
		c2 = new Conta(200.0, "Prime");
		joao = new Usuario("Joao da Silva", "111111111", "joaosilva@mailinator.com");
		manoel = new Usuario("Manoel da Silva", "22222222", "manoelsilva@mailinator.com");
	}

	@Test
	public void deveSomarTodasAsContasTrazendoOSaldoDoBanco() {
		List<Conta> contas = new ContaBuilder().addConta(c1, joao).addConta(c2, manoel).constroi();
		ContaDao dao = new ContaDao();
		dao.salvaConta(contas.get(0));
		dao.salvaConta(contas.get(1));
		Banco banco = new Banco();
		assertEquals(2, banco.getContas().size(), 0.00001);
		assertEquals(300, banco.totalSaldo(), 0.00001);
	}
}
