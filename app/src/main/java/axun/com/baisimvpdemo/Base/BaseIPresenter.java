package axun.com.baisimvpdemo.Base;

import android.content.Context;
import android.os.Handler;

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

    public void getDataByPost(String url,RequestParams params){
        if (mModule!=null){
            showProgress("");
            mModule.getNetDataByPost(url, params, new Call() {
                @Override
                public void onReceiveJson(String json) {
                    workAfterRefresh(json);
                }

                @Override
                public void onFailed(String msg) {
                    showError(msg);
                    hideProgress();
                }
            });
        }
    }

    public void getDataByGet(String url){
        if (mModule!=null){
            showProgress("");
            mModule.getNetDataByGet(url, new Call() {
                @Override
                public void onReceiveJson(String json) {
                    workAfterRefresh(json);
                }

                @Override
                public void onFailed(String msg) {
                    showError(msg);
                    hideProgress();
                }
            });
        }
    }


    private void workAfterRefresh(String json){
        showUIData(json);
        hideProgress();
        showRefreshNum();
        new Handler().postDelayed(new Runnable(){
            public void run() {
                //execute the task
                hideRefreshNum();
            }
        }, 1000);
    }


    private void showProgress(String msg){
        if (mView!=null){
            mView.showProgress(msg);
        }
    }

    private void hideProgress(){
        if (mView!=null){
            mView.hideProgress();
        }
    }

    private void showDialog(){
        if (mView!=null){
            mView.showDialog();
        }
    }

    private void hideDialog(){
        if (mView!=null){
            mView.hideDialog();
        }
    }

    private void showUIData(String json){
        if (mView!=null){
            mView.showUIData(json);
        }
    }

    private void showError(String error){
        if (mView!= null){
            mView.showErrorData(error);
        }
    }

    private void showRefreshNum(){
        if (mView!=null){
            mView.showRefreshNum();
        }
    }
    private void hideRefreshNum(){
        if (mView!=null){
            mView.hideRefreshNum();
        }
    }
}
