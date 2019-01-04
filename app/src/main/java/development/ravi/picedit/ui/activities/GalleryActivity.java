package development.ravi.picedit.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import development.ravi.picedit.R;
import development.ravi.picedit.models.ImageAlbum;
import development.ravi.picedit.presentation.presenters.activity.GalleryActivityPresenter;
import development.ravi.picedit.presentation.views.activity.GalleryView;
import development.ravi.picedit.ui.fragments.GalleryAlbumsFragment;
import development.ravi.picedit.ui.fragments.GalleryImagesFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryActivity extends MvpAppCompatActivity implements GalleryView {
    @InjectPresenter
    GalleryActivityPresenter mPresenter;

    @BindView(R.id.toolbar_gallery)
    Toolbar mToolbar;

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mToolbar.setNavigationIcon(R.drawable.ic_close_white_24dp);
        }

        mFragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.galleryFragmentFrameLayout, new GalleryAlbumsFragment())
                .commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        if (mFragmentManager.getBackStackEntryCount() == 1) {
            super.onBackPressed();
            mToolbar.setNavigationIcon(R.drawable.ic_close_white_24dp);
            mToolbar.setTitle(R.string.gallery);
        } else {
            finish();
        }
    }

    @Override
    public void showImages(ImageAlbum imageAlbum) {
        mToolbar.setTitle("pictures");
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.galleryFragmentFrameLayout, GalleryImagesFragment.newInstance(imageAlbum.getImages()))
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .addToBackStack(null)
                .commit();
    }
}