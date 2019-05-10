//package com.tensor.org.exam.config;
//
//import brave.Tracing;
//import brave.propagation.B3Propagation;
//import brave.propagation.ExtraFieldPropagation;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import zipkin2.codec.SpanBytesEncoder;
//import zipkin2.reporter.AsyncReporter;
//import zipkin2.reporter.Sender;
//import zipkin2.reporter.okhttp3.OkHttpSender;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @author liaochuntao
// */
//@Configuration
//public class ZipKinConfigure {
//
//    @Bean(name = "sender")
//    public Sender sender() {
//        return OkHttpSender.create("http://localhost:9411/api/v2/spans");
//    }
//
//    @Bean(name = "tracing")
//    public Tracing tracing(Sender sender) {
//        AsyncReporter asyncReporter = AsyncReporter.builder(sender)
//                .closeTimeout(500, TimeUnit.MILLISECONDS)
//                .build(SpanBytesEncoder.JSON_V2);
//
//        return Tracing.newBuilder()
//                .localServiceName("exam")
//                .spanReporter(asyncReporter)
//                .propagationFactory(ExtraFieldPropagation.newFactory(B3Propagation.FACTORY, "exam"))
//                .build();
//    }
//
//}