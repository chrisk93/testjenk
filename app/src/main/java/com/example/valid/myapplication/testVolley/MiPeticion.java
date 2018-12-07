package com.example.valid.myapplication.testVolley;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.kymjs.okhttp3.OkHttpStack;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.kymjs.rxvolley.client.HttpParams;
import com.kymjs.rxvolley.client.JsonRequest;
import com.kymjs.rxvolley.http.HttpConnectStack;
import com.kymjs.rxvolley.http.RequestQueue;
import com.kymjs.rxvolley.rx.Result;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.cert.CertificateException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MiPeticion {


    private static final String TAG = MiPeticion.class.getSimpleName();

    public static void realizaPeticionGET() {

        HttpParams params = new HttpParams();

        //http header, optional parameters
        //params.putHeaders("cookie", "your cookie");
        //params.putHeaders("User-Agent", "rxvolley");

        //request parameters
        params.put("limit", "20");
        params.put("offset", "20");


        HttpCallback callBack = new HttpCallback() {
            @Override
            public void onSuccess(String t) {
                super.onSuccess(t);

                Log.i(TAG, "onSuccess: " + t);

            }

            @Override
            public void onFailure(int errorNo, String strMsg) {
                super.onFailure(errorNo, strMsg);
            }
        };

        new RxVolley.Builder()
                .url("https://pokeapi.co/api/v2/pokemon/")
                .httpMethod(RxVolley.Method.GET) //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
                .cacheTime(6) //default: get 5min, post 0min
                .contentType(RxVolley.ContentType.FORM)//default FORM or JSON
                .params(params)
                .shouldCache(true) //default: get true, post false
                .callback(callBack)
                .encoding("UTF-8") //default
                .doTask();


    }

    public static void realizaPeticionGETRX() {

        HttpParams params = new HttpParams();
        //同之前的设计，传递 http 请求头可以使用 putHeaders()
        // params.putHeaders("User-Agent", "rxvolley");

        //传递 http 请求参数可以使用 put()
        params.put("limit", "20");
        params.put("offset", "20");


        Observable<Result> observable = new RxVolley.Builder() // donde va String aca se puede agregar el objetc
                .url("https://pokeapi.co/api/v2/pokemon/")
                //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
                .httpMethod(RxVolley.Method.GET)
                .cacheTime(6) //default: get 5min, post 0min
                .params(params)
                .contentType(RxVolley.ContentType.JSON)

                .getResult();  // 使用getResult()来返回RxJava数据类型


        observable.map(new Func1<Result, String>() {
            @Override
            public String call(Result result) {
                return new String(result.data);
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.i(TAG, "onNext: " + s);

                    }
                });

        //当拿到 observable 对象后，你可以设置你自己的 subscriber


    }


    public static void realizaPeticionJsonPOSTRX(Context context) {

        HttpParams params = new HttpParams();
        //同之前的设计，传递 http 请求头可以使用 putHeaders()
        // params.putHeaders("User-Agent", "rxvolley");

        //传递 http 请求参数可以使用 put()
        //params.put("limit", "20");
        //params.put("offset", "20");

        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject();
            jsonObject.put("nose", "data");
        } catch (JSONException e) {
            Log.e(TAG, "realizaPeticionJsonPOSTRX: ", e);
        }

        params.putJsonParams(jsonObject.toString());

        RxVolley.setRequestQueue(RequestQueue.newRequestQueue(RxVolley.CACHE_FOLDER, new OkHttpStack(getUnsafeOkHttpClient())));


        Observable<Result> observable = new RxVolley.Builder() // donde va String aca se puede agregar el objetc
                .url("https://pokeapi.co/api/v2/pokemon/")
                //default GET or POST/PUT/DELETE/HEAD/OPTIONS/TRACE/PATCH
                .httpMethod(RxVolley.Method.POST)
                .cacheTime(6) //default: get 5min, post 0min
                .params(params)
                .contentType(RxVolley.ContentType.JSON)

                .getResult();  // 使用getResult()来返回RxJava数据类型


        observable.map(new Func1<Result, String>() {
            @Override
            public String call(Result result) {
                return new String(result.data);
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.i(TAG, "onNext: " + s);

                    }
                });

        //当拿到 observable 对象后，你可以设置你自己的 subscriber


    }

    public static OkHttpClient getUnsafeOkHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });

            OkHttpClient okHttpClient = builder
                    .connectTimeout(40, TimeUnit.SECONDS)
                    .readTimeout(40, TimeUnit.SECONDS)
                    .writeTimeout(40, TimeUnit.SECONDS)
                    .build();
            return okHttpClient;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
