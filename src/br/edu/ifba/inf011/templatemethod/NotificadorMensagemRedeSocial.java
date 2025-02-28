package br.edu.ifba.inf011.templatemethod;

public class NotificadorMensagemRedeSocial extends NotificadorTemplate{

	@Override
	public void enviandoMensagem(String mensagem) {
		System.out.println("A mensagem abaixo foi enviada com sucesso:\n" + mensagem);
	}

}
