package axun.com.baisimvpdemo.presenter;

import android.content.Context;
import android.util.Log;

import axun.com.baisimvpdemo.Base.BaseIPresenter;
import axun.com.baisimvpdemo.net.URL;
import axun.com.baisimvpdemo.response.ItemTypeBean;
import axun.com.baisimvpdemo.util.SPUtils;
import axun.com.baisimvpdemo.view.MainView;


/**
 * Created by Administrator on 2018/1/26.
 */

public class MainPresenter extends BaseIPresenter {
    MainView mainView;

    public MainPresenter(MainView mView, Context context) {
        super(mView, context);
    }

    public void getItemData(String url){
        if (SPUtils.getBean(context,"item_type")!=null){
           showTypeItem( (ItemTypeBean) SPUtils.getBean(context,"item_type"));

        }else {
            getDataByGet(URL.typeItem);
            Log.d("MainActivity","网络");
        }
    }

    private void showTypeItem(ItemTypeBean bean){
        if (mainView!=null){
            mainView.showTypeItem(bean);
        }
    }
}
