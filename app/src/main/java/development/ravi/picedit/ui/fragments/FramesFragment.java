package development.ravi.picedit.ui.fragments;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;

import development.ravi.picedit.R;
import development.ravi.picedit.adapters.FramesAdapter;
import development.ravi.picedit.core.ImageEditorView;
import development.ravi.picedit.models.Frame;
import development.ravi.picedit.presentation.presenters.fragment.FramesPresenter;
import development.ravi.picedit.presentation.views.fragment.FramesView;
import development.ravi.picedit.utils.ToolbarUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static development.ravi.picedit.core.enums.EditorTool.FRAMES;

public class FramesFragment extends ToolFragment implements FramesView {
    @InjectPresenter
    FramesPresenter mPresenter;

    @BindView(R.id.recycler_view_frames)
    RecyclerView mRecyclerView;

    private Unbinder mUnbinder;

    private ImageEditorView mImageEditorView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageEditorView = (ImageEditorView) getActivity().findViewById(R.id.image_editor_view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frames, container, false);

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
        ToolbarUtil.updateTitle(R.string.frames, getActivity());
        mImageEditorView.changeTool(FRAMES);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void setupAdapter(List<Frame> frames) {
        FramesAdapter adapter = new FramesAdapter(frames);
        adapter.setFramesListener(frame -> mPresenter.changeOverlay(getContext(), frame));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onFrameChanged(Bitmap bitmap) {
        mImageEditorView.setFrame(bitmap);
    }
}