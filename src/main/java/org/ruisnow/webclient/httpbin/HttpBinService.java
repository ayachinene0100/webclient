package org.ruisnow.webclient.httpbin;

import reactor.core.publisher.Mono;

import java.util.Map;

public interface HttpBinService {

    Mono<Map<String, Object>> get(Map<String, Object> param);
}
