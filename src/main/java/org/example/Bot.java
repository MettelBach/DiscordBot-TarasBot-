package org.example;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Bot extends ListenerAdapter {
    private Timer timer;
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        // Логика обработки
//        event // Событие
//        .getChannel() // Берем канал
//        .sendMessage( // Отправить сообщение
//         event // Событие
//        .getMessage() // Берем сообщение из event
//        .getContentDisplay() // Из сообщения берем контент
//        )
//        .queue(); //
    }

    private ScheduledExecutorService scheduler;

    @Override
    public void onReady(ReadyEvent event) {
        event
        .getJDA()
        .getTextChannelById("1215380369713660016")
        .sendMessage("Успішно підключено")
        .queue();

        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(() -> event
                                .getJDA()
                                .getTextChannelById("1215380369713660016")
                                .sendMessage("Ваше сообщение")
                                .queue(), 24, TimeUnit.HOURS);
    }
}