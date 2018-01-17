package com.sokil.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class UserDTO {
    private Long userId;
    private String userName;
    private String userPassword;
    private String roles;
}
