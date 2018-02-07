package br.aula.testes;

import org.junit.Assert;
import org.junit.Test;

import br.aula.testes.models.Lance;
import br.aula.testes.models.Leilao;
import br.aula.testes.models.Usuario;
import br.aula.testes.servico.Avaliador;

public class AvaliadorTest {

	@Test
	public void deveRetornarOMaiorEMenorLance() {
		
		// cenario: 3 lances em ordem crescente
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");
		Leilao leilao = new Leilao("Playstation 3 Novo");
		
		leilao.propoe(new Lance(maria, 250.0));
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 400.0));
		
		// executando a acao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		// comparando a saida com o esperado
		double maiorEsperado = 400;
		double menorEsperado = 250;
		
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
		
	}

}
