package com.caito.utils.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

/**
 * @author claudio.vilas
 * date 09/2023
 */

@Getter
public enum Role {
    CUSTOMER(List.of(Permission.READ_ALL_PRODUCTS)),
    ADMINISTRATOR(Arrays.asList(Permission.READ_ALL_PRODUCTS, Permission.SAVE_ONE_PRODUCT));

    private final List<Permission> permissions;


    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
