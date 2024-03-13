package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws InterruptedException
    {
        Bot bot = new Bot();

        final String TOKEN = "MTIxNzI2MDIxMDg1MTE1MTkxNA.GdXLw0.waZKQOIwob5Bp0X3fZWFgGWU8kaVD5cBhau28s";

        // Создаем список GatewayIntent
        List<GatewayIntent> intents = new ArrayList<>();
        intents.add(GatewayIntent.GUILD_MESSAGES); // Получает уведомление о новых сообщения
        intents.add(GatewayIntent.MESSAGE_CONTENT); // Получает содержимое новых сообщений

        // Реализация функционала бота
        JDABuilder.createLight(TOKEN) // Самое простое подключение к боту
                .addEventListeners(bot) // Накидывание прослушки
                .enableIntents(intents) // Передаем список GatewayIntent
                .setStatus(OnlineStatus.ONLINE) // Статус бота ОНЛАЙН
                .setActivity(Activity.customStatus("Перечитує Кобзар")) // Что делает бот
                .build(); // Сделать
    }
}