package axun.com.baisimvpdemo.Base;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.example.vuandroidadsdk.okhttp.request.RequestParams;

/**
 * Created by Administrator on 2018/1/26.
 */

public class BaseIPresenter {
    public BaseIView mView;
    public BaseIModule mModule;
    public Context context;

    public BaseIPresenter(BaseIView mView, Context context) {
        this.mView = mView;
        this.context = context;
        mModule = new BaseIXfml(context);
    }

    public void getDataByPost(String url, RequestParams params, final boolean isRefresh){
        if (mModule!=null){
            showProgress("");
            mModule.getNetDataByPost(url, params, new Call() {
                @Override
                public void onReceiveJson(String json) {
                    workAfterGetData(isRefresh,json);
                }

                @Override
                public void onFailed(String msg) {
                    showError(msg);
                    hideProgress();
                }
            });
        }
    }

    public void getDataByGet(String url, final boolean isRefresh){
        if (mModule!=null){
            showProgress("");
            Log.d("NET","请求url："+url);
            mModule.getNetDataByGet(url, new Call() {
                @Override
                public void onReceiveJson(String json) {
                    Log.d("NET","返回json："+json);
                    workAfterGetData(isRefresh,json);
                }

                @Override
                public void onFailed(String msg) {
                    showError(msg);
                    hideProgress();
                }
            });
        }
    }


    protected void workAfterGetData(boolean isRefresh,String json){
        showUIData(isRefresh,json);
        hideProgress();
        showRefreshNum();
        new Handler().postDelayed(new Runnable(){
            public void run() {
                //execute the task
                hideRefreshNum();
            }
        }, 1000);
    }


    protected void showProgress(String msg){
        if (mView!=null){
            mView.showProgress(msg);
        }
    }

    protected void hideProgress(){
        if (mView!=null){
            mView.hideProgress();
        }
    }

    protected void showDialog(){
        if (mView!=null){
            mView.showDialog();
        }
    }

    protected void hideDialog(){
        if (mView!=null){
            mView.hideDialog();
        }
    }

    public void showUIData(boolean isRefresh,String json){
        if (mView!=null){
            mView.showUIData(isRefresh,json);
        }
    }

    protected void showError(String error){
        if (mView!= null){
            mView.showErrorData(error);
        }
    }

    protected void showRefreshNum(){
        if (mView!=null){
            mView.showRefreshNum();
        }
    }
    protected void hideRefreshNum(){
        if (mView!=null){
            mView.hideRefreshNum();
        }
    }
}
