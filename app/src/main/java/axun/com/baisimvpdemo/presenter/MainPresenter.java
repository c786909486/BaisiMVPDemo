package axun.com.baisimvpdemo.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import axun.com.baisimvpdemo.Base.BaseIPresenter;
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
        this.mainView = mView;
    }

    /**
     * 获取tab数据
     * @param url
     */
    public void getItemData(boolean isRefresh,String url){
        if (!TextUtils.isEmpty(SPUtils.getStringSp(context,"type_json"))){
//           showTypeItem( (ItemTypeBean) SPUtils.getBean(context,"item_type"));
            showUIData(isRefresh,SPUtils.getStringSp(context,"type_json"));
            Log.d("MainActivity","本地");
        }else {
            getDataByGet(url,isRefresh);
            Log.d("MainActivity","网络");
        }
    }

    /**
     * 显示精华
     */
    public void showJinhua(){
        hideAll();
        jinhua();
    }

    /**
     * 显示新帖
     */
    public void showXietie(){
        hideAll();
        xintie();
    }

    /**
     * 显示社区
     */
    public void showShequ(){
        hideAll();
        shequ();
    }

    /**
     * 显示我的
     */
    public void showWode(){
        hideAll();
        wode();
    }

    private void showTypeItem(ItemTypeBean bean){
        if (mainView!=null){
            mainView.showTypeItem(bean);
        }
    }

    private void hideAll(){
        if (mView!=null){
            mainView.hideAll();
        }
    }

    private void jinhua(){
        if (mainView!=null){
            mainView.showJinhua();
        }
    }

    private void xintie(){
        if (mainView!=null){
            mainView.showXintie();
        }
    }

    private void shequ(){
        if (mainView!=null){
            mainView.showShequ();
        }
    }

    private void wode(){
        if (mainView!=null){
            mainView.showWode();
        }
    }
}
