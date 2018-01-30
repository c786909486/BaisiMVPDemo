package axun.com.baisimvpdemo.presenter;

import android.content.Context;
import android.util.Log;

import axun.com.baisimvpdemo.Base.BaseIPresenter;
import axun.com.baisimvpdemo.fragment.JinhuaFragment;
import axun.com.baisimvpdemo.module.JinhuaModule;
import axun.com.baisimvpdemo.module.JinhuaXmfl;
import axun.com.baisimvpdemo.response.ItemTypeBean;
import axun.com.baisimvpdemo.view.JinhuaView;

/**
 * Created by Administrator on 2018/1/30.
 */

public class JinhuaPresenter extends BaseIPresenter{
    JinhuaView mView;
    JinhuaModule mModule;

    public JinhuaPresenter(JinhuaView mView, Context context) {
        super(mView, context);
        this.mView = mView;
        mModule = new JinhuaXmfl(context);
    }

    public void setTypeItems(JinhuaFragment jinhuaFragment){
        ItemTypeBean.MenusBean bean = mModule.getTypeItems(jinhuaFragment);
        Log.d("types",bean.getSubmenus().get(0).getName());
        showTabs(bean);
    }

    private void showTabs(ItemTypeBean.MenusBean bean){
        if (mView!=null){
            mView.setTabs(bean);
        }
    }
}
