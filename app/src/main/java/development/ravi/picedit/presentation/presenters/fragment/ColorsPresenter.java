package development.ravi.picedit.presentation.presenters.fragment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import development.ravi.picedit.App;
import development.ravi.picedit.models.EditorColor;
import development.ravi.picedit.presentation.views.fragment.ColorsView;

import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class ColorsPresenter extends MvpPresenter<ColorsView> {
    @Inject
    List<EditorColor> mColors;

    public ColorsPresenter() {
        App.getAppComponent().inject(this);

        getViewState().setupAdapter(mColors);
    }

}