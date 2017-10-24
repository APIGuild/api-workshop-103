package com.tw.apiguild.constant;

import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;

public class ApplicationConstants {
    public static final Key KEY = MacProvider.generateKey();
    public static final String HEADER_STRING = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
}
