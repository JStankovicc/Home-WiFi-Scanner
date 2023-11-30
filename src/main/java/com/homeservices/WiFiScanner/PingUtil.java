package com.homeservices.WiFiScanner;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PingUtil {
    public static final Map<Integer, Boolean> pingResponseMap = new ConcurrentHashMap<>();

    static {
        for (int i = 1; i <= 255; i++) {
            pingResponseMap.put(i, false);
        }
    }
}
