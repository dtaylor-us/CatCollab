package com.categories.collab.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

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

    public static void displayUserName(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        if (name.equals("anonymousUser")) {
            model.addAttribute("userName", "Log-In");
        } else {
            model.addAttribute("userName", auth.getName());
        }
    }

    public static String getUserName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName(); //get logged in username
        return userName;
    }

}
