package axun.com.baisimvpdemo.Base;

import android.content.Context;

import com.example.vuandroidadsdk.okhttp.CommonOkHttpClient;
import com.example.vuandroidadsdk.okhttp.listener.DisposeDataHandle;
import com.example.vuandroidadsdk.okhttp.listener.DisposeDataListener;
import com.example.vuandroidadsdk.okhttp.request.CommonRequest;
import com.example.vuandroidadsdk.okhttp.request.RequestParams;

/**
 * Created by Administrator on 2018/1/26.
 */

public class BaseIXfml implements BaseIModule{
    private Context context;

    public BaseIXfml(Context context) {
        this.context = context;
    }

    @Override
    public void getNetDataByPost(String url, RequestParams params, final Call call) {
        CommonOkHttpClient.post(CommonRequest.createPostRequest(url,params),new DisposeDataHandle(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                call.onReceiveJson(responseObj.toString());
            }

            @Override
            public void onFailure(Object reasonObj) {
                call.onFailed(reasonObj.toString());
            }
        }));
    }

    @Override
    public void getNetDataByGet(String url, final Call call) {
        CommonOkHttpClient.get( CommonRequest.createGetRequest(url,null),new DisposeDataHandle(new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                call.onReceiveJson(responseObj.toString());

            }

            @Override
            public void onFailure(Object reasonObj) {
                call.onFailed(reasonObj.toString());
            }
        }));
    }


}
