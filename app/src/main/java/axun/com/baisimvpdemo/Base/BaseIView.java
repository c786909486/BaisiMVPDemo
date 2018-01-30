package axun.com.baisimvpdemo.Base;

/**
 * Created by Administrator on 2018/1/26.
 */

public interface BaseIView {
    //开始刷新
//    void startRefresh();
//    //结束刷新
//    void finishRefresh();
    //显示dialog
    void showDialog();
    //隐藏dialog
    void hideDialog();
    //显示加载
    void showProgress(String msg);
    //关闭加载
    void hideProgress();
    //更新UI数据
    void showUIData(boolean isRefresh,String json);
    //显示错误数据
    void showErrorData(String error);
    //显示更新数量
    void showRefreshNum();
    //关闭更新数量
    void hideRefreshNum();
}
