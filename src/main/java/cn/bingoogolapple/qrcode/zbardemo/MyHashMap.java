package cn.bingoogolapple.qrcode.zbardemo;

import java.util.HashMap;

/**
 * Created by luoml on 2018/8/26.
 */

public class MyHashMap extends HashMap<String, Object> {
    public MyHashMap put(String key, Object v){
        super.put(key, v);
        return this;
    }
}
