package pl.mt.magazyn.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import pl.mt.magazyn.models.Order;
import pl.mt.magazyn.services.OrderService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportCreator {

    @Value("${reports.location}")
    private String reportsLocation;

    @Autowired
    OrderService orderService;

    @Autowired
    FileWriter fileWriter;

    public void createReport(LocalDate date) throws IOException {
        List<Order> orders = orderService.orders(date);

        fileWriter.writeToFile(new File(reportsLocation + "orders_" + date.toString() + ".txt"), orders.stream()
                .map(OrderReportElement::new).collect(Collectors.toList()));
    }
}
