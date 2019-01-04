package development.ravi.picedit.di;

import android.content.Context;

import development.ravi.picedit.core.model.EditorSticker;
import development.ravi.picedit.core.model.EditorText;
import development.ravi.picedit.di.modules.AppModule;
import development.ravi.picedit.di.modules.EditorModule;
import development.ravi.picedit.presentation.presenters.fragment.AdjustPresenter;
import development.ravi.picedit.presentation.presenters.fragment.ColorsPresenter;
import development.ravi.picedit.presentation.presenters.fragment.DrawingPresenter;
import development.ravi.picedit.presentation.presenters.fragment.FiltersPresenter;
import development.ravi.picedit.presentation.presenters.fragment.FontsPresenter;
import development.ravi.picedit.presentation.presenters.fragment.FramesPresenter;
import development.ravi.picedit.presentation.presenters.fragment.OverlaysPresenter;
import development.ravi.picedit.presentation.presenters.fragment.StickersPresenter;
import development.ravi.picedit.presentation.presenters.fragment.StickersSetPresenter;
import development.ravi.picedit.presentation.presenters.fragment.ToolsPresenter;
import development.ravi.picedit.ui.dialogs.FontPickerDialog;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, EditorModule.class})
public interface AppComponent {
    Context getContext();

    void inject(ToolsPresenter toolsPresenter);

    void inject(AdjustPresenter adjustPresenter);

    void inject(FiltersPresenter filtersPresenter);

    void inject(OverlaysPresenter overlaysPresenter);

    void inject(FramesPresenter framesPresenter);

    void inject(StickersSetPresenter stickersSetPresenter);

    void inject(StickersPresenter stickersPresenter);

    void inject(ColorsPresenter colorsPresenter);

    void inject(DrawingPresenter drawingPresenter);

    void inject(FontsPresenter fontsPresenter);

    void inject(FontPickerDialog fontPickerDialog);

    void inject(EditorSticker editorSticker);

    void inject(EditorText editorText);
}