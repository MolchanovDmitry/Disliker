package com.di.penopllast.vklikesremover.di.module;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;

import com.di.penopllast.vklikesremover.BuildConfig;
import com.di.penopllast.vklikesremover.Util.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.X509Certificate;

import javax.inject.Named;
import javax.inject.Singleton;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule {

    private static final String PROTOCOL = "TLSv1.2";

    @Provides
    @Named("serverUrl")
    String provideServerUrl() {
        return "https://api.vk.com/";
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@Named("serverUrl") String serverUrl, Retrofit.Builder builder,
                             OkHttpClient okHttpClient) {
        return builder
                .baseUrl(serverUrl)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    Retrofit.Builder provideRetrofitBuilder(Converter.Factory converterFactory) {
        return new Retrofit.Builder()
                .addConverterFactory(converterFactory);
    }

    @Provides
    @Singleton
    Converter.Factory provideConverterFactory(Gson gson) {
        return GsonConverterFactory
                .create(gson);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .create();
    }

    @Provides
    @Singleton
    Cache provideHttpCache(Context context) {
        return new Cache(new File(context.getCacheDir(),
                "apiResponses"), 5 * 1024 * 1024);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache, Context context) {
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
        return builder != null ? builder.build() : null;
    }

    @NonNull
    private static X509TrustManager trustManagerForCertificates()
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
            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            @SuppressLint("TrustAllX509TrustManager")
            @Override
            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        };
    }

}
