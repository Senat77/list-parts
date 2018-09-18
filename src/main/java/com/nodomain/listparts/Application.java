package com.nodomain.listparts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application
{
    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(PartRepository repository)
    {
        return (args) ->
        {
            // Только для первичного заполнения, в дальнейшем - *.sql при инициализации БД MySQL
            /*
            repository.saveAll(Arrays.asList(
                    new Part("Материнская плата", true, 3L),
                    new Part("Процессор", true, 4L),
                    new Part("Видеокарта", true, 5L),
                    new Part("Модуль памяти", true, 6L),
                    new Part("Жесткий диск", true, 7L),
                    new Part("SSD-накопитель", false, 8L),
                    new Part("Оптический привод", false, 9L),
                    new Part("Звуковая карта", false, 33L),
                    new Part("Контроллер VGA to HDMI", false, 31L),
                    new Part("Контроллер USB BlueTooth", false, 32L),
                    new Part("Контроллер USB to COM cable", false, 2L),
                    new Part("Корпус", true, 5L),
                    new Part("Блок питания", true, 4L),
                    new Part("Процессорный кулер", true, 12L),
                    new Part("Кулер", false, 12L),
                    new Part("Термопаста", false, 22L),
                    new Part("Кулер для видеокарты", false, 3L),
                    new Part("Wi-Fi роутер", false, 6L),
                    new Part("Сканер", false, 12L),
                    new Part("Сетевой адаптер", false, 17L),
                    new Part("Модем", false, 26L),
                    new Part("Кабель питания", true, 13L),
                    new Part("Монитор", true, 9L),
                    new Part("Принтер", true, 7L)
            ));
            */
        };
    }
}