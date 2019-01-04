package development.ravi.picedit.presentation.views.fragment;

import com.arellomobile.mvp.MvpView;

import development.ravi.picedit.models.Tool;

import java.util.List;

public interface ToolsView extends MvpView {
    void setupTools(List<Tool> tools);
}
