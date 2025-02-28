package br.edu.ifba.inf011.templatemethod;

public abstract class NotificadorTemplate {
	
	public void notifica(String mensagem) {
		if(!this.verificaMensagem(mensagem)) {
			this.enviandoMensagem(mensagem);
		}
	}
	
	private boolean verificaMensagem(String mensagem) {
		return mensagem.equals(null) || mensagem.equals("");
	}
	
	public abstract void enviandoMensagem(String mensagem);
	
}
