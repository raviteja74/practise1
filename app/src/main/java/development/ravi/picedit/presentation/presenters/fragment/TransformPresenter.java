package development.ravi.picedit.presentation.presenters.fragment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import development.ravi.picedit.core.enums.EditorTool;
import development.ravi.picedit.presentation.views.fragment.TransformView;

@InjectViewState
public class TransformPresenter extends MvpPresenter<TransformView> {

    public void setupTransform(EditorTool editorTool) {
        // TODO: mEditorView.setupToolFragment(editorTool);
    }
}