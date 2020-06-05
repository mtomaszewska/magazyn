package pl.mt.magazyn.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.mt.magazyn.models.Order;
import pl.mt.magazyn.services.OrderService;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportCreator {

    @Autowired
    OrderService orderService;

    @Autowired
    FileWriter fileWriter;

    public void createReport(LocalDate date) throws IOException {
        List<Order> orders = orderService.orders(date);

        fileWriter.writeToFile(new File("orders_" + date.toString() + ".txt"), orders.stream()
                .map(OrderReportElement::new).collect(Collectors.toList()));
    }
}
