package axun.com.baisimvpdemo.view;

import axun.com.baisimvpdemo.Base.BaseIView;
import axun.com.baisimvpdemo.response.ItemTypeBean;

/**
 * Created by Administrator on 2018/1/26.
 */

public interface MainView extends BaseIView{
    void showTypeItem(ItemTypeBean bean);
}
