package development.ravi.picedit.presentation.views.fragment;

import android.support.annotation.ColorInt;

import com.arellomobile.mvp.MvpView;

import development.ravi.picedit.models.BrushSize;
import development.ravi.picedit.models.EditorColor;

import java.util.List;

public interface DrawingView extends MvpView {
    void setupSizesAdapter(List<BrushSize> sizes);

    void setupColorsAdapter(List<EditorColor> colors);

    void onBrushColorChanged(@ColorInt int color);
}
