package br.edu.ifba.inf011.model.envioStrategy;

public class WhatsAppEnvioStrategy implements EnvioStrategy {
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando via WhatsApp: " + mensagem);
    }
}
