package development.ravi.picedit.ui.fragments;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;

import development.ravi.picedit.R;
import development.ravi.picedit.core.ImageEditorView;
import development.ravi.picedit.models.Text;
import development.ravi.picedit.presentation.presenters.fragment.AddTextPresenter;
import development.ravi.picedit.presentation.views.fragment.AddTextView;
import development.ravi.picedit.ui.activities.EditorActivity;
import development.ravi.picedit.ui.dialogs.FontPickerDialog;
import development.ravi.picedit.utils.ToolbarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static development.ravi.picedit.core.enums.EditorTool.TEXT;

public class TextFragment extends ToolFragment implements AddTextView {
    @InjectPresenter
    AddTextPresenter mPresenter;

    @BindView(R.id.edit_text)
    EditText mEditText;

    private Context mContext;

    private int mColor = Color.BLACK;

    private Typeface mTypeface = Typeface.DEFAULT;

    private Unbinder mUnbinder;

    private FontPickerDialog mFontPickerDialog;
    private ImageEditorView mImageEditorView;

    public static TextFragment newInstance() {
        return new TextFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageEditorView = (ImageEditorView) getActivity().findViewById(R.id.image_editor_view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);

        mUnbinder = ButterKnife.bind(this, view);

        mContext = view.getContext();
        mFontPickerDialog = new FontPickerDialog(mContext);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mImageEditorView.changeTool(TEXT);
        ToolbarUtil.updateTitle(R.string.text, getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void addText(Text text) {
        mImageEditorView.addText(text);
    }

    @Override
    public void onTextColorChanged(@ColorInt int color) {

    }

    @Override
    public void showToastMessage(@StringRes int messageText) {
        Toast.makeText(mContext, getResources().getString(messageText), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.addTextButton)
    void onClickAddText() {
        mPresenter.addText(mEditText.getText().toString(), mTypeface, mColor);
    }

    @OnClick(R.id.selectTextColorButton)
    void onClickTextColorButton() {
        //((EditorActivity) getActivity()).setupFragment(ColorsFragment.newInstance());
    }

    @OnClick(R.id.selectFontButton)
    void onClickTextButton() {
        mFontPickerDialog.show();
    }
}