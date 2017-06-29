package com.cms.common.enums.face;

import java.util.HashMap;
import java.util.Map;

public enum FaceEnums {
    anger(0,"anger"),
    contempt(1,"contempt"),
    disgust(2,"disgust"),
    fear(3,"fear"),
    happiness(4,"happiness"),
    neutral(5,"neutral"),
    sadness(6,"sadness"),
    surprise(7,"surprise");

    private Integer id;

    private String name;

    FaceEnums(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private static Map<Integer, FaceEnums> map = new HashMap<Integer, FaceEnums>();

    static {
        for (FaceEnums enums : FaceEnums.values()) {
            map.put(enums.getId(), enums);
        }
    }

    public static FaceEnums valueOf(int id) {
        return valueOf(id, null);
    }

    public static FaceEnums valueOf(int id, FaceEnums defaultValue) {
        FaceEnums enums = map.get(id);
        return enums == null ? defaultValue : enums;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}