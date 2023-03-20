package com.example.srp.utils;

import java.util.HashSet;
import java.util.Set;

public class ToolUtils {
    public static <T> Set<T> set_merge(Set<T> set_1, Set<T> set_2) {
        Set<T> my_set = new HashSet<>(set_1);
        my_set.addAll(set_2);
        return my_set;
    }
}
