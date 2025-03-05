package br.edu.ifba.inf011.model.formatoStrategy;

import br.edu.ifba.inf011.model.evento.Evento;

public class FormatoException extends Exception {
    
    private static final long serialVersionUID = 1L;
    private Evento evento;

    public FormatoException(Evento evento, String message) {
        super(message); 
        this.evento = evento;
    }


    public FormatoException(Evento evento, String message, Throwable cause) {
        super(message, cause); 
        this.evento = evento;
    }


    public FormatoException(Evento evento) {
        super("Formato inválido para o evento."); 
        this.evento = evento;
    }
   
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("Evento associado: " + evento);
    }
}
