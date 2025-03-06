# AVALIAÇÃO FINAL DA DISCIPLINA DE PADRÕES DE PROJETO

Equipe:  Matheus Conceição Bonfin, Rafael Mota Correia e Uriel Lincoln Santana Reis.

## **Padrões de Projeto Utilizados:**
### **1. Chain of Responsibility (CoR)**
#### **Participantes do Padrão:**
| Papel no CoR          | Classe/Componente                                                                       | Descrição                                                                           |
| --------------------- | --------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------- |
| **Abstract Handler**  | `AbstractNotificadorHandler`                                                            | Define a interface comum para todos os handlers e gerencia a cadeia (`setProximo`). |
| **Concrete Handlers** | `NotificadorAltaPrioridade`, `NotificadorMediaPrioridade`, `NotificadorBaixaPrioridade` | Implementam a lógica específica para tratar eventos de certas prioridades.          |
| **Client**            | Classe que configura a cadeia (ex: `Notificador`)                                       | Monta a cadeia de handlers e inicia o processamento do evento.                      |
Pasta do CoR: [Acessar Pasta](src/br/edu/ifba/inf011/model/CoR/).
#### **Por que usamos o CoR?**

- **Cumulatividade Controlada:** Permite que múltiplos handlers processem o mesmo evento sequencialmente (ex: prioridade 10 aciona WhatsApp, e-mail *e* Google Calendar);
- **Desacoplamento:** O cliente não precisa saber qual handler processará o evento;
- **Extensibilidade:** Novos handlers (ex: para SMS) podem ser adicionados sem modificar código existente e para o mesmo nível de prioridade. Podem existir dois ou mais handlers para um evento com mesma prioridade.

#### **Por que usamos uma classe abstrata em vez de uma interface no CoR?**

- No padrão CoR clássico, interfaces são comuns, mas neste cenário, a classe abstrata foi preferida para **evitar repetição de código** e **garantir coesão**, já que todos os handlers compartilham a mesma estrutura e dependências. Interfaces seriam úteis se os handlers tivessem implementações radicalmente diferentes, o que não é o caso aqui.


---

### **2. Strategy**
#### **Participantes do Padrão:**
| Papel no Strategy       | Classe/Componente                                                             | Descrição                                                                                    |
| ----------------------- | ----------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------- |
| **Strategy Interface**  | `FormatoStrategy`, `EnvioStrategy`                                            | Define a interface comum para algoritmos de formatação e envio.                              |
| **Concrete Strategies** | `WhatsAppFormatoStrategy`, `EmailFormatoStrategy`, `EmailEnvioStrategy`, etc. | Implementam algoritmos específicos (ex: formatação para WhatsApp).                           |
| **Context**             | Handlers (`NotificadorAltaPrioridade`, etc.)                                  | Usa a estratégia para executar um comportamento variável (ex: `formatoStrategy.formatar()`). |
Pasta do Strategy de Formatação: [Acessar Pasta](src/br/edu/ifba/inf011/model/formatoStrategy/).
Pasta do Strategy de Envio: [Acessar Pasta](src/br/edu/ifba/inf011/model/envioStrategy/).
#### **Por que usamos o Strategy (duas vezes)?**

- **Variação Dinâmica:** Permite trocar formatos/canais de envio em tempo de execução (ex: prioridade alta usa WhatsApp, média usa e-mail).  
- **Separação de Lógica:** Isola regras complexas de formatação/envio em classes dedicadas.  
- **Reúso:** Estratégias como `EnvioEmailStrategy` podem ser compartilhadas entre handlers.

---
## **Exceção "Nenhum Handler Disponível"**
### **Contexto:**
Na versão original, o handler de baixa prioridade (`NotificadorBaixaPrioridade`) processava **todos os eventos** (condição `return true`). Na nova versão, ele só processa eventos de prioridade 1-4 que iniciem em até 2 dias. Assim, eventos fora dessas condições podem não ter handlers
### **Implementação:**

1. **Retorno Booleano no `notificar`:**  
   Cada handler retorna `true` se processou o evento.  
2. **Verificação no Client:**  
   Após a cadeia processar, o cliente verifica se algum handler executou a ação. Se não, lança `NenhumHandlerException`.

**Classe:** `NenhumHandlerException`  
**Link:** [Ver código](/src/br/edu/ifba/inf011/model/CoR/NenhumHandlerException.java).

