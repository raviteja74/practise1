package development.ravi.picedit.presentation.views.activity;

import com.arellomobile.mvp.MvpView;

import development.ravi.picedit.models.ImageAlbum;

public interface GalleryView extends MvpView {
    void showImages(ImageAlbum imageAlbum);
}
