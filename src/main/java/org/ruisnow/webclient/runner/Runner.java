package org.ruisnow.webclient.runner;

import org.ruisnow.webclient.httpbin.HttpBinService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Runner implements CommandLineRunner {

    final HttpBinService httpBinService;

    public Runner(HttpBinService httpBinService) {
        this.httpBinService = httpBinService;
    }

    @Override
    public void run(String... args) throws Exception {
        httpBinService.get(new HashMap<>()).block();
    }
}
