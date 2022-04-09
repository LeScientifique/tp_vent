package com.defi.tp_vente.service;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}