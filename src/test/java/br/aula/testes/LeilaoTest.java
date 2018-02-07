package br.aula.testes;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import br.aula.testes.models.Lance;
import br.aula.testes.models.Leilao;
import br.aula.testes.models.Usuario;

public class LeilaoTest {
	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		assertEquals(0, leilao.getLances().size());

		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));

		assertEquals(1, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
	}

	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
		leilao.propoe(new Lance(new Usuario("Steve Wozniak"), 3000));

		assertEquals(2, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(3000, leilao.getLances().get(1).getValor(), 0.00001);
	}

	@Test
	public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook Pro 15");
		Usuario steveJobs = new Usuario("Steve Jobs");
		leilao.propoe(new Lance(steveJobs, 2000));
		leilao.propoe(new Lance(steveJobs, 3000));
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
	}
}
