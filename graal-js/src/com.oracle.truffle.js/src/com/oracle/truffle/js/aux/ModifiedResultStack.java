package com.oracle.truffle.js.aux;

import com.oracle.truffle.api.source.SourceSection;

import java.util.HashMap;
import java.util.Map;

public class ModifiedResultStack {
    public static Map<SourceSection, Object> results = new HashMap<>();

    public static Object getResult(SourceSection sourceSection) {
        if (!results.isEmpty()) {
            Object newResult = results.getOrDefault(sourceSection, null);
            if (newResult!=null) {
                results.remove(sourceSection);
                return newResult;
            }
        }
        return null;
    }
}
