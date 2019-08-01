package moe.yojigen.hoshiimiki.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.tencent.liteav.play.SuperPlayerConst;
import com.tencent.liteav.play.SuperPlayerGlobalConfig;
import com.tencent.liteav.play.SuperPlayerModel;
import com.tencent.liteav.play.SuperPlayerView;
import com.tencent.rtmp.TXLiveConstants;

import moe.yojigen.hoshiimiki.R;
import moe.yojigen.hoshiimiki.VideoPlayer;

public class VideoPlayerActivity extends AppCompatActivity {
    SuperPlayerView mSuperPlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        mSuperPlayerView = findViewById(R.id.superplayer);
        SuperPlayerGlobalConfig globalConfig = SuperPlayerGlobalConfig.getInstance();
        globalConfig.enableHWAcceleration = true;
        globalConfig.renderMode = TXLiveConstants.RENDER_MODE_FULL_FILL_SCREEN;
        VideoPlayer.getInstance().getVideoPlayerActivityModel().observe(this, videoPlayerActivityModel -> {
            SuperPlayerModel model = new SuperPlayerModel();
            model.title = videoPlayerActivityModel.getTitle();
            model.url = videoPlayerActivityModel.getUrl();
            mSuperPlayerView.playWithModel(model);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 重新开始播放
        if (mSuperPlayerView.getPlayState() == SuperPlayerConst.PLAYSTATE_PLAY) {
            mSuperPlayerView.onResume();
            if (mSuperPlayerView.getPlayMode() == SuperPlayerConst.PLAYMODE_FLOAT) {
                mSuperPlayerView.requestPlayMode(SuperPlayerConst.PLAYMODE_WINDOW);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 停止播放
        if (mSuperPlayerView.getPlayMode() != SuperPlayerConst.PLAYMODE_FLOAT) {
            mSuperPlayerView.onPause();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 释放
        mSuperPlayerView.release();
        if (mSuperPlayerView.getPlayMode() != SuperPlayerConst.PLAYMODE_FLOAT) {
            mSuperPlayerView.resetPlayer();
        }
    }
}
