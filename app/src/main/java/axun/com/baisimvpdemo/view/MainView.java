package axun.com.baisimvpdemo.view;

import axun.com.baisimvpdemo.Base.BaseIView;
import axun.com.baisimvpdemo.response.ItemTypeBean;

/**
 * Created by Administrator on 2018/1/26.
 */

public interface MainView extends BaseIView{
    //显示tab
    void showTypeItem(ItemTypeBean bean);
    //隐藏所有fragment
    void hideAll();
    //显示精华fragment
    void showJinhua();
    //显示新帖
    void showXintie();
    //显示社区
    void showShequ();
    //显示我的
    void showWode();

}
