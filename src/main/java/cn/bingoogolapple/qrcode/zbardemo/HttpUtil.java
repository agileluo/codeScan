package cn.bingoogolapple.qrcode.zbardemo;

import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Created by luoml on 2018/8/26.
 */

public class HttpUtil {
    public static void sendMessage(final Object data){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    HttpClient httpClient = new DefaultHttpClient();
                    String url = "http://47.96.28.158:8080/qCode/save";
                    HttpPost httpPost = new HttpPost(url);
                    httpPost.setEntity(new StringEntity(new ObjectMapper().writeValueAsString(data), "UTF-8"));
                    httpPost.setHeader("Content-Type", "application/json");
                    HttpResponse httpResponse = httpClient.execute(httpPost);
                    int code = httpResponse.getStatusLine().getStatusCode();
                    if ( code == 200 ) {
                        String rev = EntityUtils.toString(httpResponse.getEntity());
                    }
                }catch(Exception e){
                    Log.d("error", e.getMessage(), e);
                }
            }
        }).start();

    }
}
