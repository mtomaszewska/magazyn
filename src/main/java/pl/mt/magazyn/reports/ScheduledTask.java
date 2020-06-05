package pl.mt.magazyn.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;

@Component
public class ScheduledTask {

    @Autowired
    ReportCreator reportCreator;

    @Scheduled(fixedRate = 5000)
    public void executeTask() throws IOException {
        reportCreator.createReport(LocalDate.now()/*.minusDays(1)*/);
    }
}
