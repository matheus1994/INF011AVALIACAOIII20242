package br.edu.ifba.inf011.model.envioStrategy;

public class GoogleCalendarEnvioStrategy implements EnvioStrategy {
  
    public void enviar(String mensagem) {
        System.out.println("Adicionando ao Google Calendar: " + mensagem);
    }
    
    
}
