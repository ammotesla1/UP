package com.example.UP.Models;

import org.springframework.security.core.GrantedAuthority;

public enum Post implements GrantedAuthority {
    ADMIN, VIEWER, PURCHASING, WAREHOUSE, CASHIER, DELIVERY;

    @Override
    public String getAuthority() { return name(); }
}
