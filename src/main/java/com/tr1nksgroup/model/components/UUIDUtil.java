package com.tr1nksgroup.model.components;

import java.util.UUID;

public class UUIDUtil {

    public static UUID create(UUIDAvailableCheckBackCall backCall) {
        UUID uuid;
        do {
            uuid = UUID.randomUUID();
        } while (!backCall.check());
        return uuid;
    }

    public interface UUIDAvailableCheckBackCall {
        boolean check();
    }
}
