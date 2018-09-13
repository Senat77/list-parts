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
            repository.saveAll(Arrays.asList(
                    new Part("МАТ. ПЛАТА , SOCKET 1151, INTEL B250, 4ХDDR4, 6ХSATA III, VGA/DVI, 6xUSB3.1,mATX", true, 3L),
                    new Part("ПРОЦЕССОР , 2 CORE, 3200MHZ, LGA1151, L3 2MB, INTEL GRAPHICS HD 610", true, 2L),
                    new Part("ВИДЕОКАРТА SVGA PCI EXPRESS, 2GB GDDR3, 64BIT, 800/5010MHZ, LP,VGA/DVI/HDMI", true, 1L),
                    new Part("ПРИВОД ВНЕШНИЙ DVD-RW , USB 2.0, BLACK, SLIM, RETAIL", false, 4L),
                    new Part("Карта звуковая PCI - 4CH (c-media 8738) Box (10715)", false, 12L)
            ));

        };
    }
}