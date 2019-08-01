package moe.yojigen.hoshiimiki;

import android.content.Context;
import android.content.Intent;

import androidx.lifecycle.MutableLiveData;

import java.io.File;

import moe.yojigen.hoshiimiki.modle.VideoPlayerActivityModel;
import moe.yojigen.hoshiimiki.view.VideoPlayerActivity;

public class VideoPlayer {
    private static VideoPlayer mVideoPlayer = new VideoPlayer();
    private MutableLiveData<VideoPlayerActivityModel> mVideoPlayerActivityModel = new MutableLiveData<>();

    public static VideoPlayer getInstance() {
        return mVideoPlayer;
    }

    public void playOnActivity(Context context, String title, String url) {
        VideoPlayerActivityModel videoPlayerActivityModel = new VideoPlayerActivityModel();
        videoPlayerActivityModel.setTitle(title);
        videoPlayerActivityModel.setUrl(url);
        setVideoPlayerActivityModel(videoPlayerActivityModel);
        Intent intent = new Intent(context, VideoPlayerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void playOnActivity(Context context, String title, File file) {
        playOnActivity(context, title, "file://" + file.getAbsoluteFile());
    }

    public void playOnActivity(Context context, String url) {
        playOnActivity(context, "视频播放", url);
    }

    public void playOnActivity(Context context, File file) {
        playOnActivity(context, "视频播放", "file://" + file.getAbsoluteFile());
    }

    public MutableLiveData<VideoPlayerActivityModel> getVideoPlayerActivityModel() {
        if (mVideoPlayerActivityModel.getValue() == null) {
            mVideoPlayerActivityModel.setValue(new VideoPlayerActivityModel());
        }
        return mVideoPlayerActivityModel;
    }

    public void setVideoPlayerActivityModel(VideoPlayerActivityModel mVideoPlayerActivityModel) {
        this.mVideoPlayerActivityModel.setValue(mVideoPlayerActivityModel);
    }
}