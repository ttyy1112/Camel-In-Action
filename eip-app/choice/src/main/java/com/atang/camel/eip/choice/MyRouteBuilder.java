package com.atang.camel.eip.choice;

import org.apache.camel.builder.RouteBuilder;

/**
 * Notice this route is in Java code, but hawtio can visualize the route in the web browser
 * and you can add breakpoints and debug the route.
 */
public class MyRouteBuilder extends RouteBuilder {

    public void configure() {
        from("timer:foo?period=1000&synchronous=true")
                .transform(simple("${random(1000)}"))
                .choice()
                .when(simple("${body} > 500"))
                .log("High number1 ${body}")
                .endChoice()
//                .to("mock:high")
                .when(simple("${body} > 500"))
                .log("High number2 ${body}")
                .endChoice()
//                .to("mock:high")
                .otherwise()
                .log("Low number ${body}")
//                .to("mock:low");
        .end()
        ;
    }

}
