package development.ravi.picedit.presentation.views.fragment;

import android.support.annotation.ColorInt;
import android.support.annotation.StringRes;

import com.arellomobile.mvp.MvpView;

import development.ravi.picedit.models.Text;

public interface AddTextView extends MvpView {
    void addText(Text text);

    void onTextColorChanged(@ColorInt int color);

    void showToastMessage(@StringRes int messageText);
}
