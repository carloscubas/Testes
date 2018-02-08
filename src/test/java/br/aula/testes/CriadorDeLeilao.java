package br.aula.testes;

import br.aula.testes.models.Lance;
import br.aula.testes.models.Leilao;
import br.aula.testes.models.Usuario;

public class CriadorDeLeilao {
	private Leilao leilao;

	public CriadorDeLeilao() {
	}

	public CriadorDeLeilao para(String descricao) {
		this.leilao = new Leilao(descricao);
		return this;
	}

	public CriadorDeLeilao lance(Usuario usuario, double valor) {
		leilao.propoe(new Lance(usuario, valor));
		return this;
	}

	public Leilao constroi() {
		return leilao;
	}
}