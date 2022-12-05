// Generated by view binder compiler. Do not edit!
package com.api.trabalhofinal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.api.trabalhofinal.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityAddEventBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final EditText Name;

  @NonNull
  public final Button buttonSalvar;

  @NonNull
  public final EditText editTextDate;

  @NonNull
  public final EditText latitude;

  @NonNull
  public final EditText longitude;

  @NonNull
  public final EditText textViewDescricao;

  private ActivityAddEventBinding(@NonNull ConstraintLayout rootView, @NonNull EditText Name,
      @NonNull Button buttonSalvar, @NonNull EditText editTextDate, @NonNull EditText latitude,
      @NonNull EditText longitude, @NonNull EditText textViewDescricao) {
    this.rootView = rootView;
    this.Name = Name;
    this.buttonSalvar = buttonSalvar;
    this.editTextDate = editTextDate;
    this.latitude = latitude;
    this.longitude = longitude;
    this.textViewDescricao = textViewDescricao;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityAddEventBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityAddEventBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_add_event, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityAddEventBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Name;
      EditText Name = ViewBindings.findChildViewById(rootView, id);
      if (Name == null) {
        break missingId;
      }

      id = R.id.buttonSalvar;
      Button buttonSalvar = ViewBindings.findChildViewById(rootView, id);
      if (buttonSalvar == null) {
        break missingId;
      }

      id = R.id.editTextDate;
      EditText editTextDate = ViewBindings.findChildViewById(rootView, id);
      if (editTextDate == null) {
        break missingId;
      }

      id = R.id.latitude;
      EditText latitude = ViewBindings.findChildViewById(rootView, id);
      if (latitude == null) {
        break missingId;
      }

      id = R.id.longitude;
      EditText longitude = ViewBindings.findChildViewById(rootView, id);
      if (longitude == null) {
        break missingId;
      }

      id = R.id.textView_Descricao;
      EditText textViewDescricao = ViewBindings.findChildViewById(rootView, id);
      if (textViewDescricao == null) {
        break missingId;
      }

      return new ActivityAddEventBinding((ConstraintLayout) rootView, Name, buttonSalvar,
          editTextDate, latitude, longitude, textViewDescricao);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
