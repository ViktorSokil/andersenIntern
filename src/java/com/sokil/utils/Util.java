package com.sokil.utils;


import com.sokil.entity.Role;

import java.util.HashSet;
import java.util.Set;

public class Util {

    public static Set<Role> parseRoles(String userRoles) {
        Set<Role> roles = new HashSet<>();
        Role role = new Role();
        String[] words = userRoles.split(" ");
        for (String word: words){
            if(!word.equals(" ") && !word.equals("")){
                role.setRole(word);
                roles.add(role);
            }
        }
        return roles;
    }
}

