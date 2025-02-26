# INF011AVALIACAOIII20242

Identifique e escreva os padrões adequados para resolver os problemas apresentados.
Você deve escrever um notificador, capaz de formatar e enviar mensagens notificando a ocorrência de eventos. Uma
primeira versão desta classe foi escrita com o código apresentado a seguir.

public class Notificador {
public void notificar(Evento e) {
if(e.getPrioridade() == 10 && e.iniciaEm(LocalDate.now())) {
String formatada = this.formatarMensagemParaWhatsApp(e);
this.adicionandoEventoAoGoogleCalendar(formatada);
this.enviandoMensagemEmail(formatada);
this.enviandoMensagemWhatsApp(formatada);
}else if(e.getPrioridade() >= 5 && e.iniciaEm(LocalDate.now())){
String formatada = this.formatarMensagemParaEmail(e);
this.adicionandoEventoAoGoogleCalendar(formatada);
this.enviandoMensagemEmail(formatada);
}else if(e.getPrioridade() >= 1 && e.getPrioridade() < 5 &&
e.iniciaEntre(LocalDateTime.now().minus(2, ChronoUnit.DAYS),
 LocalDateTime.now())){
String formatada = this.formatarMensagemParaEmail(e);
this.adicionandoEventoAoGoogleCalendar(formatada);
}
}
 …
}


A questão é que este código se mostra excessivamente inflexível, não permitindo a alteração dinâmica das regras de
envio, nem a configuração de diferentes regras de envio, a depender do tipo de evento.
Além disso, esse código tende a crescer com o tempo, dificultando a manutenção da classe Notificador.
Ainda assim se deseja que seja mantida a estrutura básica do algoritmo:
1. considera-se a data do evento e sua prioridade para então:
(a) se for o caso, adicionar o evento ao Google Calendar
(b) formatar para um determinado tipo de forma de envio (e-mail, whatsapp, sms, mensagem de rede social)
(c) notificar a ocorrência do evento para a forma de envio considerada (e-mail, whatsapp, sms, mensagem de
rede social).
Sua tarefa é refatorar o notificador existente, utilizando os princípios de design orientados a objetos e em particular,
adotando padrões de projeto, que permitam, que os requisitos funcionais e não funcionais apresentados sejam
contemplados.
Adicionalmente forneça uma documentação simples:
1. Indicando o/os padrões de projeto escolhidos e justificando suas escolhas;
2. Detalhando as classes participantes do projeto e seus papéis nos padrões de projeto escolhido;
3. Sem essa documentação, o código não será analisado.
ATENÇÃO
 As soluções devem ser escritas em código JAVA
