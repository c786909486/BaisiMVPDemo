package axun.com.baisimvpdemo.video;

import android.content.Context;
import android.util.AttributeSet;

import axun.com.baisimvpdemo.R;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by CKZ on 2017/3/8.
 */

public class SimpleJCVideo extends JCVideoPlayerStandard {


    public SimpleJCVideo(Context context) {
        super(context);
    }

    public SimpleJCVideo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int getLayoutId() {
        return R.layout.simple_video_layout;
    }
}
