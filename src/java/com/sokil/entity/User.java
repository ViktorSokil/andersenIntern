package com.sokil.entity;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private Long userId;
    private String userName;
    private String userPassword;
    private Set<String> roles;
}
