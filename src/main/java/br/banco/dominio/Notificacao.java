package br.banco.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.banco.dominio.Conta;

public class Notificacao {
	private List<Conta> contasNotificadas = new ArrayList<Conta>();
	private Calendar data;

	public Notificacao(Calendar data) {
		this.data = data;
	}

	public void addContas(Conta conta) {
		this.contasNotificadas.add(conta);
	}

	public List<Conta> getContasNotificadas() {
		return this.contasNotificadas;
	}
}