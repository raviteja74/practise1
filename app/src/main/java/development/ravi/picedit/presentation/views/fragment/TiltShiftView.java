package development.ravi.picedit.presentation.views.fragment;

import com.arellomobile.mvp.MvpView;

import development.ravi.picedit.core.enums.EditorTool;

public interface TiltShiftView extends MvpView {
    void onTiltShiftChanged(EditorTool command);
}