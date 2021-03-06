package com.ictwsn.utils.speech;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Speech {

    public static final String SERVERURL = "http://vop.baidu.com/server_api";
    public static String TOKEN = "";
    public static final String SPEECHFILENAME = "D:\\FFOutput\\Feb 24, 11.29.wav";
    public static final String APIKEY = "Dt70455RDRmose5bs3qFoTLp";
    public static final String SECRETKEY = "9b2aa909022349be024b4a93d6ea252e";
    public static final String CUID = "94-DE-80-23-9B-23";

    public static final String SPD = "3";
    public static final String AUDIOFILENAME = "Audio2";

    //获取百度的认证密匙
    public static String getToken() {

        CloseableHttpClient httpclient = HttpClients.createDefault();

        String getTokenURL = "https://openapi.baidu.com/oauth/2.0/token?grant_type=client_credentials" +
                "&client_id=" + Speech.APIKEY + "&client_secret=" + Speech.SECRETKEY;

        HttpGet httpGet = new HttpGet(getTokenURL);

        String body = "";

        CloseableHttpResponse response = null;
        try {
            response = httpclient.execute(httpGet);
            try {
                System.out.println(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                body = EntityUtils.toString(entity, "utf-8");
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return body;
    }


}
