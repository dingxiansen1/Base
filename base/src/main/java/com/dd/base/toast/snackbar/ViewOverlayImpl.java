
package com.dd.base.toast.snackbar;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;

/**
 * Backward-compatible implementation of {@link android.view.ViewOverlay}. TODO(b/144937975): Remove
 * and use the official version from androidx when it's available.
 *
 * @hide
 */
public interface ViewOverlayImpl {

  /**
   * Adds a Drawable to the overlay. The bounds of the drawable should be relative to the host view.
   * Any drawable added to the overlay should be removed when it is no longer needed or no longer
   * visible.
   *
   * @param drawable The Drawable to be added to the overlay. This drawable will be drawn when the
   *     view redraws its overlay.
   * @see #remove(Drawable)
   */
  void add(@NonNull Drawable drawable);

  /**
   * Removes the specified Drawable from the overlay.
   *
   * @param drawable The Drawable to be removed from the overlay.
   * @see #add(Drawable)
   */
  void remove(@NonNull Drawable drawable);
}
