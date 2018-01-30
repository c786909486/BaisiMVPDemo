package axun.com.baisimvpdemo.module;

import axun.com.baisimvpdemo.Base.BaseIModule;
import axun.com.baisimvpdemo.fragment.JinhuaFragment;
import axun.com.baisimvpdemo.response.ItemTypeBean;

/**
 * Created by Administrator on 2018/1/30.
 */

public interface JinhuaModule extends BaseIModule{

    ItemTypeBean.MenusBean getTypeItems(JinhuaFragment jinhuaFragment);
}
