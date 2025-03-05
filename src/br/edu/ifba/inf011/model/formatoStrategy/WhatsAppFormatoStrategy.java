package br.edu.ifba.inf011.model.formatoStrategy;

import br.edu.ifba.inf011.model.evento.Evento;

public class WhatsAppFormatoStrategy implements FormatoStrategy {
    
    public String formatar(Evento evento) {
        return "[WhatsApp] " + evento.getDescricao();
    }
    
    
}
