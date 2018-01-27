package axun.com.baisimvpdemo.net;

/**
 * Created by Administrator on 2018/1/26.
 */

public class URL {

    //分类
    public static final String typeItem = "http://s.budejie.com/public/list-appbar/budejie-android-6.8.9/";

    public static final String commonApi(int page){
        return "budejie-android-6.8.9/"+(page-1)+"-20.json";
    }
    public static class Jinhua{

        //推荐
        public static String tuijian(int page){
            return "http://c.api.budejie.com/topic/list/jingxuan/1/budejie-android-6.8.9/"+(page-1)+"-20.json";
        }
        //推荐内容
        public static String tuijianMore = "http://d.api.budejie.com/topic/recommend/budejie-android-6.8.9/0-10.json";
        //视频
        public static String video(int page){
            return "http://c.api.budejie.com/topic/list/jingxuan/41/budejie-android-6.8.9/"+(page-1)+"-20.json";
        }
        //视频更多
        public static String videoMore = "http://d.api.budejie.com/topic/list/chuanyue/41/budejie-android-6.8.9/0-8.json";

        //图片
        public static String picture(int page){
            return "http://c.api.budejie.com/topic/list/jingxuan/10/budejie-android-6.8.9/"+(page-1)+"-20.json";
        }
        //图片更多
        public static String pictureMore = "http://d.api.budejie.com/topic/list/chuanyue/10/budejie-android-6.8.9/0-8.json";

        //段子
        public static final String duanzi (int page){
            return "http://s.budejie.com/topic/tag-topic/64/hot/budejie-android-6.8.9/"+(page-1)+"-20.json";
        }
        //段子更多
        public static final String duanziMore = "http://d.api.budejie.com/topic/list/chuanyue/29/budejie-android-6.8.9/0-8.json";

        //短剧
        public static final String duanju(int page){
            return "http://s.budejie.com/topic/tag-topic/50436/hot/budejie-android-6.8.9/"+(page-1)+"-20.json";
        }

        //王者荣耀
        public static final String rongyao(int page){
            return "http://s.budejie.com/topic/tag-topic/15341/hot/budejie-android-6.8.9/"+(page-1)+"-20.json";
        }
        //排行
        public static final String paihang(int page){
            return "http://s.budejie.com/topic/list/remen/1/budejie-android-6.8.9/"+(page-1)+"-20.json";
        }
        //互动
    }


}
