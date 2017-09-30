package com.categories.collab.common;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static int getIterSize(Iterable<?> it) {
        if (it instanceof Collection)
            return ((Collection<?>)it).size();

        int i = 0;
        for (Object obj : it) i++;
        return i;
    }

    public static <E> List<E> iterableToList(Iterable<E> iterable) {
        if(iterable instanceof List) {
            return (List<E>) iterable;
        }
        ArrayList<E> list = new ArrayList<E>();
        if(iterable != null) {
            for(E e: iterable) {
                list.add(e);
            }
        }
        return list;
    }

    public static String createRandomCode(int codeLength, String id) {
        return new SecureRandom()
                .ints(codeLength, 0, id.length())
                .mapToObj(id::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
