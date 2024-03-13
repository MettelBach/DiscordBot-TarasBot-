package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class App
{
    public static void main( String[] args ) throws InterruptedException
    {
        Bot bot = new Bot();

        final String TOKEN = "MTIxNzI2MDIxMDg1MTE1MTkxNA.GMSZF8.E-_7n6nWNjO5dIiz2TRmA8uhjBn1Oy3X-5jwKs";

        // Реализация функционала бота
        JDABuilder.createLight(TOKEN) // Самое простое подключение к боту
                  .addEventListeners(bot) // Накидывание прослушки
                  .enableIntents( // Какие функции включаем (Какие события полчаю от Дискорд)
                          List.of( // Колекция функций
                                  GatewayIntent.GUILD_MESSAGES, // Получает уведомление о новых сообщения
                                  GatewayIntent.MESSAGE_CONTENT // Получает содержимое новых сообщений
                          )
                  )
                  .setStatus(OnlineStatus.ONLINE) // Статус бота ОНЛАЙН
                  .setActivity(Activity.customStatus("Перечитує Кобзар")) // Что делает бот
                  .build(); // Сделать
    }
}