package com.telesign;

import java.io.IOException;
import java.net.Proxy;
import java.security.GeneralSecurityException;
import java.util.Map;

/**
 * A set of APIs that deliver deep phone number data attributes that help optimize the end user
 * verification process and evaluate risk.
 */
public class PhoneIdClient extends RestClient {

    private static final String PHONEID_RESOURCE = "/v1/phoneid/%s";

    public PhoneIdClient(String customerId, String apiKey) {
        super(customerId, apiKey);
    }

    public PhoneIdClient(String customerId, String apiKey, String restEndpoint) {
        super(customerId, apiKey, restEndpoint);
    }

    public PhoneIdClient(String customerId,
                         String apiKey,
                         String restEndpoint,
                         Integer connectTimeout,
                         Integer readTimeout,
                         Integer writeTimeout,
                         Proxy proxy,
                         final String proxyUsername,
                         final String proxyPassword) {
        super(customerId, apiKey, restEndpoint, connectTimeout, readTimeout, writeTimeout, proxy, proxyUsername, proxyPassword);
    }

    /**
     * The PhoneID API provides a cleansed phone number, phone type, and telecom carrier information to determine the
     * best communication method - SMS or voice.
     * <p>
     * See https://developer.telesign.com/docs/phoneid-api for detailed API documentation.
     */
    public TelesignResponse phoneid(String phoneNumber, Map<String, String> params) throws IOException, GeneralSecurityException {

        return this.post(String.format(PHONEID_RESOURCE, phoneNumber), params);
    }
}
