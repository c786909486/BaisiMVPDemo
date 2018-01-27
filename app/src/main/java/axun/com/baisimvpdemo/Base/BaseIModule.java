package axun.com.baisimvpdemo.Base;

import com.example.vuandroidadsdk.okhttp.request.RequestParams;

/**
 * Created by Administrator on 2018/1/26.
 */

public interface BaseIModule {

    void getNetDataByPost(String url, RequestParams params, Call call);

    void getNetDataByGet(String url,Call call);



}
