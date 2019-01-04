package development.ravi.picedit.presentation.presenters.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import development.ravi.picedit.App;
import development.ravi.picedit.models.Overlay;
import development.ravi.picedit.presentation.views.fragment.OverlaysView;
import development.ravi.picedit.utils.BitmapUtil;

import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;

@InjectViewState
public class OverlaysPresenter extends MvpPresenter<OverlaysView> {
    @Inject
    Lazy<List<Overlay>> mOverlays;

    public OverlaysPresenter() {
        App.getAppComponent().inject(this);
        getViewState().setupAdapter(mOverlays.get());
    }

    public void changeOverlay(@NonNull Context context, Overlay overlay) {
        Bitmap bitmap = BitmapUtil.drawable2Bitmap(context, overlay.getImage());

        getViewState().onOverlayChanged(bitmap);
    }
}