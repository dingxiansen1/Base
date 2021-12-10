package com.dd.base.toast.snackbar;

/** Interface that defines the behavior of the main content of a transient bottom bar. */
public interface ContentViewCallback {
  /**
   * Animates the content of the transient bottom bar in.
   *
   * @param delay Animation delay.
   * @param duration Animation duration.
   */
  void animateContentIn(int delay, int duration);

  /**
   * Animates the content of the transient bottom bar out.
   *
   * @param delay Animation delay.
   * @param duration Animation duration.
   */
  void animateContentOut(int delay, int duration);
}
