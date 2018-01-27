package axun.com.baisimvpdemo.Base;

/**
 * Created by Administrator on 2018/1/26.
 */

public interface Call {
    void onReceiveJson(String json);
    void onFailed(String msg);
}
