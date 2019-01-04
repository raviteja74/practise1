package development.ravi.picedit.presentation.presenters.fragment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import development.ravi.picedit.App;
import development.ravi.picedit.models.Tool;
import development.ravi.picedit.presentation.views.fragment.ToolsView;

import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;

@InjectViewState
public class ToolsPresenter extends MvpPresenter<ToolsView> {
    @Inject
    Lazy<List<Tool>> mTools;

    public ToolsPresenter() {
        App.getAppComponent().inject(this);
        getViewState().setupTools(mTools.get());
    }
}