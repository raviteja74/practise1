package development.ravi.picedit.presentation.presenters.fragment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import development.ravi.picedit.core.enums.EditorTool;
import development.ravi.picedit.presentation.views.fragment.TiltShiftView;

@InjectViewState
public class TiltShiftFragmentPresenter extends MvpPresenter<TiltShiftView> {
    public void changeTiltShift(EditorTool command) {
        getViewState().onTiltShiftChanged(command);
    }
}