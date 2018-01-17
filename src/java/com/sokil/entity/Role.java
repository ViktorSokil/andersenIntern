package com.sokil.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Role {
    private Long roleId;
    private String role;
    private List<User> users;
}
