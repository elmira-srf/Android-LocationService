// Generated by view binder compiler. Do not edit!
package com.jk.locationservicesdemo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.jk.locationservicesdemo.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnOpenMap;

  @NonNull
  public final Button btnReverseGeocoding;

  @NonNull
  public final View divider;

  @NonNull
  public final View divider2;

  @NonNull
  public final EditText editAddress;

  @NonNull
  public final TextView tvAddress;

  @NonNull
  public final TextView tvGeocoding;

  @NonNull
  public final TextView tvLocationAddress;

  @NonNull
  public final TextView tvLocationCoordinates;

  @NonNull
  public final TextView tvReverseGeocoding;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnOpenMap,
      @NonNull Button btnReverseGeocoding, @NonNull View divider, @NonNull View divider2,
      @NonNull EditText editAddress, @NonNull TextView tvAddress, @NonNull TextView tvGeocoding,
      @NonNull TextView tvLocationAddress, @NonNull TextView tvLocationCoordinates,
      @NonNull TextView tvReverseGeocoding) {
    this.rootView = rootView;
    this.btnOpenMap = btnOpenMap;
    this.btnReverseGeocoding = btnReverseGeocoding;
    this.divider = divider;
    this.divider2 = divider2;
    this.editAddress = editAddress;
    this.tvAddress = tvAddress;
    this.tvGeocoding = tvGeocoding;
    this.tvLocationAddress = tvLocationAddress;
    this.tvLocationCoordinates = tvLocationCoordinates;
    this.tvReverseGeocoding = tvReverseGeocoding;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_open_map;
      Button btnOpenMap = ViewBindings.findChildViewById(rootView, id);
      if (btnOpenMap == null) {
        break missingId;
      }

      id = R.id.btn_reverse_geocoding;
      Button btnReverseGeocoding = ViewBindings.findChildViewById(rootView, id);
      if (btnReverseGeocoding == null) {
        break missingId;
      }

      id = R.id.divider;
      View divider = ViewBindings.findChildViewById(rootView, id);
      if (divider == null) {
        break missingId;
      }

      id = R.id.divider2;
      View divider2 = ViewBindings.findChildViewById(rootView, id);
      if (divider2 == null) {
        break missingId;
      }

      id = R.id.edit_address;
      EditText editAddress = ViewBindings.findChildViewById(rootView, id);
      if (editAddress == null) {
        break missingId;
      }

      id = R.id.tv_address;
      TextView tvAddress = ViewBindings.findChildViewById(rootView, id);
      if (tvAddress == null) {
        break missingId;
      }

      id = R.id.tv_geocoding;
      TextView tvGeocoding = ViewBindings.findChildViewById(rootView, id);
      if (tvGeocoding == null) {
        break missingId;
      }

      id = R.id.tv_location_address;
      TextView tvLocationAddress = ViewBindings.findChildViewById(rootView, id);
      if (tvLocationAddress == null) {
        break missingId;
      }

      id = R.id.tv_location_coordinates;
      TextView tvLocationCoordinates = ViewBindings.findChildViewById(rootView, id);
      if (tvLocationCoordinates == null) {
        break missingId;
      }

      id = R.id.tv_reverse_geocoding;
      TextView tvReverseGeocoding = ViewBindings.findChildViewById(rootView, id);
      if (tvReverseGeocoding == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, btnOpenMap, btnReverseGeocoding,
          divider, divider2, editAddress, tvAddress, tvGeocoding, tvLocationAddress,
          tvLocationCoordinates, tvReverseGeocoding);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
