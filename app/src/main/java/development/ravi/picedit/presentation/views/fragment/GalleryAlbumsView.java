package development.ravi.picedit.presentation.views.fragment;

import com.arellomobile.mvp.MvpView;

import development.ravi.picedit.models.ImageAlbum;

import java.util.List;

public interface GalleryAlbumsView extends MvpView {
    void showNoImages();

    void setupAdapter(List<ImageAlbum> imageAlbums);
}
