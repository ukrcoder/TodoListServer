package com.event.planner.utils;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.util.Spliterators.spliteratorUnknownSize;

/**
 * Created by Anton Shvechikov on 23.02.16.
 */
public class Lists {

    public static <T> List<T> iteratorToList(Iterator<T> i) {
        return StreamSupport.stream(spliteratorUnknownSize(i, Spliterator.ORDERED), false).collect(Collectors.<T>toList());
    }
}
