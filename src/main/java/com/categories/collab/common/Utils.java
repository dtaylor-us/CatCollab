package com.categories.collab.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Utils {

    public static int getIterSize(Iterable<?> it) {
        if (it instanceof Collection)
            return ((Collection<?>) it).size();

        int i = 0;
        for (Object obj : it) i++;
        return i;
    }

    public static <E> List<E> iterableToList(Iterable<E> iterable) {
        if (iterable instanceof List) {
            return (List<E>) iterable;
        }
        ArrayList<E> list = new ArrayList<E>();
        if (iterable != null) {
            for (E e : iterable) {
                list.add(e);
            }
        }
        return list;
    }

}
