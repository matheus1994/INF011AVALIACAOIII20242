package br.edu.ifba.inf011.model.CoR;

import br.edu.ifba.inf011.model.envioStrategy.EnvioStrategy;
import br.edu.ifba.inf011.model.evento.Evento;
import br.edu.ifba.inf011.model.formatoStrategy.FormatoStrategy;
import br.edu.ifba.inf011.model.googlecalendarservice.GoogleCalendarException;
import br.edu.ifba.inf011.model.googlecalendarservice.GoogleCalendarService;

public abstract class AbstractNotificadorHandler {
	
    protected AbstractNotificadorHandler proximo;
    protected GoogleCalendarService googleCalendar;
    protected FormatoStrategy formatoStrategy;
    protected EnvioStrategy envioStrategy;

    public AbstractNotificadorHandler(GoogleCalendarService googleCalendar, 
                              FormatoStrategy formatoStrategy, 
                              EnvioStrategy envioStrategy) {
        this.googleCalendar = googleCalendar;
        this.formatoStrategy = formatoStrategy;
        this.envioStrategy = envioStrategy;
    }

    
    public void setProximo(AbstractNotificadorHandler proximo) {
        this.proximo = proximo;
    }

    
    public void notificar(Evento evento) throws GoogleCalendarException {
        if (podeProcessar(evento)) {
            processarNotificacao(evento);
        }
        if (proximo != null) {
            proximo.notificar(evento);
        }
    }

    
    protected abstract boolean podeProcessar(Evento evento);
    protected abstract void processarNotificacao(Evento evento) throws GoogleCalendarException;
    
    
}
