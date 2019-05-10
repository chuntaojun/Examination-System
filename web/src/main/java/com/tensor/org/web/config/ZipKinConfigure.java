//package com.tensor.org.web.config;
//
//import brave.Tracing;
//import brave.propagation.B3Propagation;
//import brave.propagation.ExtraFieldPropagation;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.Async;
//import zipkin2.Span;
//import zipkin2.codec.SpanBytesEncoder;
//import zipkin2.reporter.AsyncReporter;
//import zipkin2.reporter.Sender;
//import zipkin2.reporter.okhttp3.OkHttpSender;
//
///**
// * @author liaochuntao
// */
//@Configuration
//public class ZipKinConfigure {
//
//    @Bean(name = "sender")
//    public Sender sender() {
//        return OkHttpSender.create("http://127.0.0.1:9411/api/v2/spans");
//    }
//
//    @Bean(name = "asyncReporter")
//    public AsyncReporter<Span> asyncReporter() {
//        return AsyncReporter.create(sender());
//    }
//
//    @Bean(name = "tracing")
//    public Tracing tracing() {
//        return Tracing.newBuilder()
//                .localServiceName("web")
//                .spanReporter(asyncReporter())
//                .propagationFactory(ExtraFieldPropagation.newFactory(B3Propagation.FACTORY, "web"))
//                .build();
//    }
//
//}
