package development.ravi.picedit.presentation.views.fragment;

import com.arellomobile.mvp.MvpView;

import development.ravi.picedit.models.EditorColor;

import java.util.List;

public interface ColorsView extends MvpView {
    void setupAdapter(List<EditorColor> colors);
}
