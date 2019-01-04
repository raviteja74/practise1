package development.ravi.picedit.presentation.views.fragment;

import android.graphics.Bitmap;

import com.arellomobile.mvp.MvpView;

import development.ravi.picedit.models.Frame;

import java.util.List;

public interface FramesView extends MvpView {
    void setupAdapter(List<Frame> frames);

    void onFrameChanged(Bitmap bitmap);
}
