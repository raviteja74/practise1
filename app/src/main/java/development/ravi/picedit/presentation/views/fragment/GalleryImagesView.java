package development.ravi.picedit.presentation.views.fragment;

import com.arellomobile.mvp.MvpView;

import development.ravi.picedit.models.Image;

import java.util.List;

public interface GalleryImagesView extends MvpView {
    void setupAdapter(List<Image> images);

    void editImage(String imagePath);
}
