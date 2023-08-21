package org.ruisnow.webclient.config;

import io.netty.handler.logging.LogLevel;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.logging.AdvancedByteBufFormat;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClientCustomizer webClientCustomizer() {
        HttpClient httpClient = HttpClient.create()
                // DEBUG日志级别时，输出【请求/返回】详细信息
                .wiretap(this.getClass().getCanonicalName(), LogLevel.DEBUG, AdvancedByteBufFormat.TEXTUAL);

        return builder -> {
            builder.clientConnector(new ReactorClientHttpConnector(httpClient));
        };
    }
}

