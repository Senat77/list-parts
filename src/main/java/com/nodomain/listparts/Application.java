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
                    new Part("Motherboard INTEL B150 1", true, 3L),
                    new Part("Motherboard INTEL B250 2", true, 4L),
                    new Part("Motherboard INTEL B250 3", true, 5L),
                    new Part("Motherboard INTEL B250 4", true, 6L),
                    new Part("Motherboard INTEL B250 5", true, 7L),
                    new Part("Motherboard INTEL B250 6", true, 8L),
                    new Part("Motherboard INTEL B250 7", true, 9L),
                    new Part("Motherboard INTEL B250 8", true, 33L),
                    new Part("Motherboard INTEL B250 9", true, 31L),
                    new Part("Motherboard INTEL B250 10", true, 32L),
                    new Part("ПРОЦЕССОР , 2 CORE, 3200MHZ, LGA1151, L3 2MB, INTEL GRAPHICS HD 610", true, 2L),
                    new Part("ВИДЕОКАРТА SVGA PCI EXPRESS, 2GB GDDR3, 64BIT, 800/5010MHZ, LP,VGA/DVI/HDMI", true, 1L),
                    new Part("ПРИВОД ВНЕШНИЙ DVD-RW , USB 2.0, BLACK, SLIM, RETAIL", false, 4L),
                    new Part("Карта звуковая PCI - 4CH (c-media 8738) Box (10715)", false, 12L)
            ));

        };
    }
}