package br.edu.ifba.inf011.model.envioStrategy;

public class EmailEnvioStrategy implements EnvioStrategy {
   
    public void enviar(String mensagem) {
        System.out.println("Enviando via Email: " + mensagem);
    }
    
    
}