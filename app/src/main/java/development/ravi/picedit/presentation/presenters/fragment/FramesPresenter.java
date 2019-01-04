package development.ravi.picedit.presentation.presenters.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import development.ravi.picedit.App;
import development.ravi.picedit.models.Frame;
import development.ravi.picedit.presentation.views.fragment.FramesView;
import development.ravi.picedit.utils.BitmapUtil;

import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;

@InjectViewState
public class FramesPresenter extends MvpPresenter<FramesView> {
    @Inject
    Lazy<List<Frame>> mFrames;

    public FramesPresenter() {
        App.getAppComponent().inject(this);
        getViewState().setupAdapter(mFrames.get());
    }

    public void changeOverlay(@NonNull Context context, Frame frame) {
        Bitmap bitmap = BitmapUtil.drawable2Bitmap(context, frame.getImage());

        getViewState().onFrameChanged(bitmap);
    }
}