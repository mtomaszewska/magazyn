package pl.mt.magazyn;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Scheduled(fixedRate = 5000)
    public void executeTask() {
        System.out.println("test");
    }
}
