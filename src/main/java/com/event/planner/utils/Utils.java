package com.event.planner.utils;

/**
 * Created by Anton Shvechikov on 24.02.16.
 */
public class Utils {

    public static Long convert(String s) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            return 0L;
        }
    }
}
