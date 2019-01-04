package development.ravi.picedit.presentation.views.fragment;

import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import development.ravi.picedit.models.Sticker;
import development.ravi.picedit.models.StickersSet;

import java.util.ArrayList;
import java.util.List;

public interface StickersSetView extends MvpView {
    void setupAdapter(List<StickersSet> stickersSets);

    @StateStrategyType(SkipStrategy.class)
    void showStickers(@StringRes int title, ArrayList<Sticker> stickers);
}