package development.ravi.picedit.core;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

import com.arellomobile.mvp.MvpView;

import development.ravi.picedit.core.enums.EditorTool;
import development.ravi.picedit.core.model.Drawing;
import development.ravi.picedit.core.model.EditorLinearTiltShift;
import development.ravi.picedit.core.model.EditorSticker;
import development.ravi.picedit.core.model.EditorText;
import development.ravi.picedit.core.model.EditorRadialTiltShift;
import development.ravi.picedit.core.model.EditorVignette;

import java.util.List;

interface EditorView extends MvpView {
    void setupImage(Bitmap bitmap, Matrix imageMatrix, RectF imageRect);

    void showOriginalImage(boolean display);

    void onToolChanged(EditorTool tool);

    void onImageAdjusted(Paint paint);

    void onOverlayChanged(Bitmap bitmap, Matrix matrix, Paint paint);

    void onFilterChanged(Paint paint);

    void onFrameChanged(Bitmap bitmap, Matrix matrix);

    void onTextAdded(List<EditorText> texts);

    void onStickerAdded(List<EditorSticker> stickers);

    void onVignetteUpdated(EditorVignette vignette);

    void onRadialTiltShiftUpdated(EditorRadialTiltShift radialTiltShift);

    void onLinearTiltShiftUpdated(EditorLinearTiltShift linearTiltShift);

    void onStraightenTransformChanged(Matrix transformMatrix);

    void updateDrawing(Paint paint, Path path);

    void updateDrawing(List<Drawing> drawings);

    void updateView();

    void onApplyChanges();

    void enableDrawingCache();
}