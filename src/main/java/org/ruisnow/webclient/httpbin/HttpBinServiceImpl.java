package org.ruisnow.webclient.httpbin;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class HttpBinServiceImpl implements HttpBinService {

    private final WebClient webClient;

    public HttpBinServiceImpl(WebClient.Builder builder) {
        webClient = builder.baseUrl("httpbin.org")
                .build();
    }

    @Override
    public Mono<Map<String, Object>> get(Map<String, Object> param) {
        return webClient.get()
                .uri("/get")
                .attributes(attr -> attr.putAll(param))
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
    }
}
