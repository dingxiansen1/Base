
package com.dd.base.toast.snackbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;


class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {

  ViewGroupOverlayApi14(Context context, ViewGroup hostView, View requestingView) {
    super(context, hostView, requestingView);
  }

  static ViewGroupOverlayApi14 createFrom(ViewGroup viewGroup) {
    return (ViewGroupOverlayApi14) ViewOverlayApi14.createFrom(viewGroup);
  }

  @Override
  public void add(@NonNull View view) {
    overlayViewGroup.add(view);
  }

  @Override
  public void remove(@NonNull View view) {
    overlayViewGroup.remove(view);
  }
}
