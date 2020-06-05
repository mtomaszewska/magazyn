package pl.mt.magazyn.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.mt.magazyn.models.Order;
import pl.mt.magazyn.models.OrderElement;
import pl.mt.magazyn.models.Product;
import pl.mt.magazyn.services.OrderService;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

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

        createOrdersReport(date, orders);
        createProductReport(date, orders);
    }

    private void createOrdersReport(LocalDate date, List<Order> orders) throws IOException {
        fileWriter.writeToFile(new File(reportsLocation + "orders_" + date.toString() + ".txt"), orders.stream()
                .map(OrderReportElement::new).collect(Collectors.toList()));
    }

    private void createProductReport(LocalDate date, List<Order> orders) throws IOException {
        Map<Product, List<OrderElement>> elementsByProduct = orders.stream()
                .flatMap(order -> order.getOrderElements().stream())
                .collect(groupingBy(OrderElement::getProduct));

        List<ProductReportElement> productReportElements = new ArrayList<>();
        for (Map.Entry<Product, List<OrderElement>> entry : elementsByProduct.entrySet()){
            Product product = entry.getKey();
            List<OrderElement> elements = entry.getValue();
            BigDecimal totalQuantity = BigDecimal.ZERO;
            for(OrderElement element: elements){
                totalQuantity = totalQuantity.add(element.getQuantity());
            }

            productReportElements.add(new ProductReportElement(product, totalQuantity));
        }

        fileWriter.writeToFile(
                new File(reportsLocation + "products_" + date.toString() + ".txt"), productReportElements);
    }
}
