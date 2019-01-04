package development.ravi.picedit.presentation.presenters.fragment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import development.ravi.picedit.App;
import development.ravi.picedit.models.Font;
import development.ravi.picedit.presentation.views.fragment.FontsView;

import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class FontsPresenter extends MvpPresenter<FontsView> {
    @Inject
    List<Font> mFonts;

    public FontsPresenter() {
        App.getAppComponent().inject(this);

        getViewState().setupAdapter(mFonts);
    }

}
