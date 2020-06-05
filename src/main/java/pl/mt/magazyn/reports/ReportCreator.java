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

    private final static String ORDER_PREFIX = "orders";
    private final static String PRODUCT_PREFIX = "products";

    @Value("${reports.location}")
    private String reportsLocation;

    @Autowired
    private final OrderService orderService;

    @Autowired
    private final FileWriter fileWriter;

    public ReportCreator(OrderService orderService, FileWriter fileWriter) {
        this.orderService = orderService;
        this.fileWriter = fileWriter;
    }

    public void createReport(LocalDate date) throws IOException {
        List<Order> orders = orderService.orders(date);

        createOrdersReport(date, orders);
        createProductReport(date, orders);
    }

    private void createOrdersReport(LocalDate date, List<Order> orders) throws IOException {
        fileWriter.writeToFile(new File(String.format("%s%s%s.txt", reportsLocation, ORDER_PREFIX, date.toString())), orders.stream()
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
                new File(String.format("%s%s%s.txt", reportsLocation, PRODUCT_PREFIX, date.toString())), productReportElements);
    }
}
