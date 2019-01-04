package development.ravi.picedit.presentation.presenters.fragment;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import development.ravi.picedit.presentation.views.fragment.GalleryAlbumsView;
import development.ravi.picedit.tasks.ImageFetchTask;

@InjectViewState
public class GalleryAlbumsPresenter extends MvpPresenter<GalleryAlbumsView> {
    public void fetchImages(Context context) {
        ImageFetchTask imageFetchTask = new ImageFetchTask(context);
        imageFetchTask.setOnImageLoadedListener(albums -> {
            if (albums != null) {
                getViewState().setupAdapter(albums);
            } else {
                getViewState().showNoImages();
            }
        });
        imageFetchTask.execute();
    }
}