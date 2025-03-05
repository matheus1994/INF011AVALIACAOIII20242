package br.edu.ifba.inf011.main;

import java.time.LocalDateTime;

import br.edu.ifba.inf011.model.Geolocalizacao;
import br.edu.ifba.inf011.model.evento.Lembrete;
import br.edu.ifba.inf011.model.googlecalendarservice.GoogleCalendarException;
import br.edu.ifba.inf011.model.googlecalendarservice.GoogleCalendarService;
import br.edu.ifba.inf011.notificador.Notificador;

public class Main {
    public static void main(String[] args) {
        try {
            
            GoogleCalendarService googleCalendar = new GoogleCalendarService();
            Notificador notificador = new Notificador(googleCalendar);
            Geolocalizacao geo = new Geolocalizacao(0.0, 0.0);
            
            Lembrete lembreteAlta = new Lembrete(
                "Lembrete de alta prioridade",
                LocalDateTime.now(),                  // início
                LocalDateTime.now().plusHours(1),     // término
                10,                                   // prioridade
                geo
            );
            
            Lembrete lembreteMedia = new Lembrete(
                "Lembrete de média prioridade",
                LocalDateTime.now(),                  
                LocalDateTime.now().plusHours(1),     
                7,                                   
                geo
            );
            
            Lembrete lembreteBaixa = new Lembrete(
                "Lembrete de baixa prioridade",
                LocalDateTime.now().minusDays(1),     
                LocalDateTime.now().plusHours(1),     
                3,                                   
                geo
            );
            
            System.out.println("=== Teste de Lembrete de Alta Prioridade ===");
            notificador.notificar(lembreteAlta);
            
            System.out.println("\n=== Teste de Lembrete de Média Prioridade ===");
            notificador.notificar(lembreteMedia);
            
            System.out.println("\n=== Teste de Lembrete de Baixa Prioridade ===");
            notificador.notificar(lembreteBaixa);
            
        } catch (GoogleCalendarException e) {
            System.err.println("Erro ao interagir com o Google Calendar: " + e.getMessage());
        }
    }
}
