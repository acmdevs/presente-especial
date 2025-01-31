package br.com.acmdevs.presente_especial.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    @Scheduled(cron = "0 0 12 * * ?") // Exemplo: executa todos os dias ao meio-dia
    public void agendarEntrega() {
        // Lógica para agendar a entrega ou enviar notificações
        System.out.println("Enviando presente ou agendando entrega...");
    }
}
