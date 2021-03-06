package development.ravi.picedit.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

import development.ravi.picedit.R;
import development.ravi.picedit.core.ImageEditorView;
import development.ravi.picedit.presentation.presenters.fragment.TransformPresenter;
import development.ravi.picedit.presentation.views.fragment.TransformView;
import development.ravi.picedit.ui.activities.EditorActivity;
import development.ravi.picedit.utils.ToolbarUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static development.ravi.picedit.core.enums.EditorTool.TRANSFORM;
import static development.ravi.picedit.core.enums.EditorTool.TRANSFORM_HORIZONTAL;
import static development.ravi.picedit.core.enums.EditorTool.TRANSFORM_STRAIGHTEN;
import static development.ravi.picedit.core.enums.EditorTool.TRANSFORM_VERTICAL;

public class TransformFragment extends MvpAppCompatFragment implements TransformView {
    @InjectPresenter
    TransformPresenter mPresenter;

    private Unbinder mUnbinder;

    private EditorActivity mEditorActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        mEditorActivity = (EditorActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transform, container, false);

        mUnbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        ((ImageEditorView) getActivity().findViewById(R.id.image_editor_view))
                .changeTool(TRANSFORM);
        ToolbarUtil.updateTitle(R.string.transform, getActivity());
        ToolbarUtil.updateSubtitle(null, getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        super.onPrepareOptionsMenu(menu);
    }

    @OnClick(R.id.transformHorizontalButton)
    void onClickTransformHorizontal() {
        mEditorActivity.setupFragment(
                ImageAdjustmentFragment.newInstance(TRANSFORM_HORIZONTAL)
        );
    }

    @OnClick(R.id.transformStraightenButton)
    void onClickTransformStraighten() {
        mEditorActivity.setupFragment(
                ImageAdjustmentFragment.newInstance(TRANSFORM_STRAIGHTEN)
        );
    }

    @OnClick(R.id.transformVerticalButton)
    void onClickTransformVertical() {
        mEditorActivity.setupFragment(
                ImageAdjustmentFragment.newInstance(TRANSFORM_VERTICAL)
        );
    }
}
