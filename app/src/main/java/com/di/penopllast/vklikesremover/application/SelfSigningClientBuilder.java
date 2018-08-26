package com.di.penopllast.vklikesremover.application;

import android.annotation.SuppressLint;

import com.di.penopllast.vklikesremover.Util.Utils;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by di on 15.02.2018.
 */

public class SelfSigningClientBuilder {
    private static final String PROTOCOL = "TLSv1.2";

    public static OkHttpClient createClient() {

        X509TrustManager trustManager;
        SSLSocketFactory sslSocketFactory;
        OkHttpClient.Builder builder = null;
        try {
            trustManager = trustManagerForCertificates();
            SSLContext sslContext = SSLContext.getInstance(PROTOCOL);

            TrustManager[] trustAllCerts = new TrustManager[]{trustManager};
            sslContext.init(null, trustAllCerts, null);
            sslSocketFactory = sslContext.getSocketFactory();

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            builder = new OkHttpClient.Builder()
                    .sslSocketFactory(sslSocketFactory, trustManager)
                    .addInterceptor(logging)
                    .hostnameVerifier((s, sslSession) -> true);



        } catch (GeneralSecurityException e) {
            Utils.print("GeneralSecurityException " + e);
        }
        return builder.build();
    }

    static X509TrustManager trustManagerForCertificates()
            throws GeneralSecurityException {
        TrustManagerFactory tmf = TrustManagerFactory
                .getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init((KeyStore) null);

        X509TrustManager x509Tm = null;
        for (TrustManager tm : tmf.getTrustManagers()) {
            if (tm instanceof X509TrustManager) {
                x509Tm = (X509TrustManager) tm;
                break;
            }
        }

        final X509TrustManager finalTm = x509Tm;
        return new X509TrustManager() {
            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return finalTm != null ? finalTm.getAcceptedIssuers() : new X509Certificate[0];
            }

            @SuppressLint("TrustAllX509TrustManager")
            @Override
            public void checkClientTrusted(X509Certificate[] certs, String authType) {}

            @SuppressLint("TrustAllX509TrustManager")
            @Override
            public void checkServerTrusted(X509Certificate[] certs, String authType) {}
        };
    }
}
