package br.edu.ifba.inf011.model.CoR;

import br.edu.ifba.inf011.model.envioStrategy.EnvioStrategy;
import br.edu.ifba.inf011.model.evento.Evento;
import br.edu.ifba.inf011.model.formatoStrategy.FormatoStrategy;
import br.edu.ifba.inf011.model.googlecalendarservice.GoogleCalendarException;
import br.edu.ifba.inf011.model.googlecalendarservice.GoogleCalendarService;

public class NotificadorBaixaPrioridade extends AbstractNotificadorHandler {

    public NotificadorBaixaPrioridade(GoogleCalendarService googleCalendar, 
                                     FormatoStrategy formatoStrategy, 
                                     EnvioStrategy envioStrategy) {
        super(googleCalendar, formatoStrategy, envioStrategy);
    }

    
    @Override
    protected boolean podeProcessar(Evento evento) {
        return true;
    }

    
    @Override
    protected void processarNotificacao(Evento evento) throws GoogleCalendarException {
        String mensagem = formatoStrategy.formatar(evento);
        googleCalendar.adicionar(mensagem);
    }
    
    
}
