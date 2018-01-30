package axun.com.baisimvpdemo.module;

import android.content.Context;
import android.util.Log;

import axun.com.baisimvpdemo.Base.BaseIXfml;
import axun.com.baisimvpdemo.fragment.JinhuaFragment;
import axun.com.baisimvpdemo.response.ItemTypeBean;

/**
 * Created by Administrator on 2018/1/30.
 */

public class JinhuaXmfl extends BaseIXfml implements JinhuaModule{

    public JinhuaXmfl(Context context) {
        super(context);
    }

    @Override
    public ItemTypeBean.MenusBean getTypeItems(JinhuaFragment jinhuaFragment) {
        ItemTypeBean.MenusBean bean = (ItemTypeBean.MenusBean) jinhuaFragment.getArguments().getSerializable("typeItem");
        Log.d("JINHUA",bean.getName());
        return bean;
    }
}
