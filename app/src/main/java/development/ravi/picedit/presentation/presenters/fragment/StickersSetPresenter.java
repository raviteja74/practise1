package development.ravi.picedit.presentation.presenters.fragment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import development.ravi.picedit.App;
import development.ravi.picedit.models.Sticker;
import development.ravi.picedit.models.StickersSet;
import development.ravi.picedit.presentation.views.fragment.StickersSetView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;

@InjectViewState
public class StickersSetPresenter extends MvpPresenter<StickersSetView> {
    @Inject
    Lazy<List<StickersSet>> mStickersSets;

    public StickersSetPresenter() {
        App.getAppComponent().inject(this);
        getViewState().setupAdapter(mStickersSets.get());
    }

    public void stickersSetClicked(StickersSet stickersSet) {
        ArrayList<Sticker> stickers = new ArrayList<>(stickersSet.getStickers());

        getViewState().showStickers(stickersSet.getTitle(), stickers);
    }
}