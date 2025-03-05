package br.edu.ifba.inf011.notificador;

import br.edu.ifba.inf011.model.CoR.AbstractNotificadorHandler;
import br.edu.ifba.inf011.model.CoR.NenhumHandlerException;
import br.edu.ifba.inf011.model.CoR.NotificadorAltaPrioridade;
import br.edu.ifba.inf011.model.CoR.NotificadorBaixaPrioridade;
import br.edu.ifba.inf011.model.CoR.NotificadorMediaPrioridade;
import br.edu.ifba.inf011.model.envioStrategy.EmailEnvioStrategy;
import br.edu.ifba.inf011.model.envioStrategy.GoogleCalendarEnvioStrategy;
import br.edu.ifba.inf011.model.envioStrategy.WhatsAppEnvioStrategy;
import br.edu.ifba.inf011.model.evento.Evento;
import br.edu.ifba.inf011.model.formatoStrategy.EmailFormatoStrategy;
import br.edu.ifba.inf011.model.formatoStrategy.GoogleCalendarFormatoStrategy;
import br.edu.ifba.inf011.model.formatoStrategy.WhatsAppFormatoStrategy;
import br.edu.ifba.inf011.model.googlecalendarservice.GoogleCalendarException;
import br.edu.ifba.inf011.model.googlecalendarservice.GoogleCalendarService;


public class Notificador {
    private AbstractNotificadorHandler cadeia;

    public Notificador(GoogleCalendarService googleCalendar) {
     
    	AbstractNotificadorHandler baixa = new NotificadorBaixaPrioridade(
            googleCalendar,
            new GoogleCalendarFormatoStrategy(),
            new GoogleCalendarEnvioStrategy() 
        );
    	
    	AbstractNotificadorHandler media = new NotificadorMediaPrioridade(
            googleCalendar,
            new EmailFormatoStrategy(),
            new EmailEnvioStrategy()
        );
    	
    	AbstractNotificadorHandler alta = new NotificadorAltaPrioridade(
            googleCalendar,
            new WhatsAppFormatoStrategy(),
            new WhatsAppEnvioStrategy()
        );

        // Constrói a cadeia: alta -> média -> baixa
    	
        alta.setProximo(media);
        media.setProximo(baixa);

        this.cadeia = alta;
    }
    

    public void notificar(Evento evento) throws GoogleCalendarException, NenhumHandlerException {
        boolean processado = cadeia.notificar(evento);
        if (!processado) {
            throw new NenhumHandlerException("Nenhum handler disponível para processar o evento: " + evento.getDescricao());
        }
    }

	
}
