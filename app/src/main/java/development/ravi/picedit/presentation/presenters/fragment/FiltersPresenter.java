package development.ravi.picedit.presentation.presenters.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import development.ravi.picedit.App;
import development.ravi.picedit.models.Filter;
import development.ravi.picedit.presentation.views.fragment.FiltersView;
import development.ravi.picedit.ui.fragments.TransparencyFragment;
import development.ravi.picedit.utils.BitmapUtil;

import java.util.List;

import javax.inject.Inject;

import dagger.Lazy;

@InjectViewState
public class FiltersPresenter extends MvpPresenter<FiltersView> {
    @Inject
    Lazy<List<Filter>> mFilters;

    public FiltersPresenter(@NonNull Context context, @NonNull Bitmap bitmap) {
        App.getAppComponent().inject(this);

        Uri uri = BitmapUtil.getUriOfBitmap(context, bitmap);

        getViewState().setupFiltersAdapter(uri, mFilters.get());
    }

    public void changeFilter(@NonNull Filter filter) {
        getViewState().filterChanged(filter.getColorMatrix());
    }

    public void changeFilterIntensity(@NonNull Paint filterPaint) {
        getViewState().onChangeFilterIntensityClicked(
                TransparencyFragment.newInstance(filterPaint)
        );
    }
}