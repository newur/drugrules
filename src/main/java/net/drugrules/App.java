package net.drugrules;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

import java.util.Map;

@SpringBootApplication
@EnableProcessApplication
public class App {

    public static void main(String... args) {
        SpringApplication.run(App.class, args);
    }

    @Autowired
    private RuntimeService runtimeService;

    @EventListener
    private void processPostDeploy(PostDeployEvent event) {
        Map<String, Object> processVariables = Map.of("Season", "good", "Age", 29);
        runtimeService.startProcessInstanceByKey("P001_Process", processVariables);
    }
}
