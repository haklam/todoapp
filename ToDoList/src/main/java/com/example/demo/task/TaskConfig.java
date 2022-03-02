package com.example.demo.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class TaskConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            TaskRepository repository) {
        return args -> {
            Task butikken = new Task(
                    "Husk å kjøpe såpe, kjøttdeig og potetgull.",
                    "Gå på butikken"
            );
            Task barnehage = new Task(
                    "Husk å hente i barnehagen mandag, onsdag og fredag.",
                    "Hente i barnehage"
            );
            Task blomster = new Task(
                    "Monsteraplanten skal ha 4dl vann hver torsdag klokken 18, og rosene må ha nytt vann annenhver dag.",
                    "Vanne blomster"
            );
            Task pakke = new Task(
                    "Hente pakken fra XXL innen fristen onsdag 9.3.",
                    "Hente pakke"
            );
            Task sprint = new Task(
                    "Alle oppgaver på sprinten må være ferdig på fredag når sprinten er over.",
                    "Oppgave sprint"
            );

            repository.saveAll(
                    List.of(butikken, barnehage, blomster, pakke, sprint)
            );
        };
    }
}
