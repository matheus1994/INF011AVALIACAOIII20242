package br.edu.ifba.inf011.model.CoR;

import java.time.LocalDate;

import br.edu.ifba.inf011.model.envioStrategy.EnvioStrategy;
import br.edu.ifba.inf011.model.evento.Evento;
import br.edu.ifba.inf011.model.formatoStrategy.FormatoStrategy;
import br.edu.ifba.inf011.model.googlecalendarservice.GoogleCalendarException;
import br.edu.ifba.inf011.model.googlecalendarservice.GoogleCalendarService;

public class NotificadorMediaPrioridade extends AbstractNotificadorHandler {

    public NotificadorMediaPrioridade(GoogleCalendarService googleCalendar, 
                                    FormatoStrategy formatoStrategy, 
                                     EnvioStrategy envioStrategy) {
        super(googleCalendar, formatoStrategy, envioStrategy);
    }

    
    @Override
    protected boolean podeProcessar(Evento evento) {
        return evento.getPrioridade() >= 5 && evento.iniciaEm(LocalDate.now());
    }

    
    @Override
    protected void processarNotificacao(Evento evento) throws GoogleCalendarException {
        String mensagem = formatoStrategy.formatar(evento);
        envioStrategy.enviar(mensagem);
    }
    
    
}
