package development.ravi.picedit.presentation.views.fragment;

import com.arellomobile.mvp.MvpView;

import development.ravi.picedit.models.Font;

import java.util.List;

public interface FontsView extends MvpView {
    void setupAdapter(List<Font> fonts);
}
