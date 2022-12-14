// Generated by view binder compiler. Do not edit!
package com.api.trabalhofinal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.api.trabalhofinal.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDescricaoBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonReturn;

  @NonNull
  public final TextView textViewDescricao;

  @NonNull
  public final TextView textViewTituloDescricao;

  private ActivityDescricaoBinding(@NonNull ConstraintLayout rootView, @NonNull Button buttonReturn,
      @NonNull TextView textViewDescricao, @NonNull TextView textViewTituloDescricao) {
    this.rootView = rootView;
    this.buttonReturn = buttonReturn;
    this.textViewDescricao = textViewDescricao;
    this.textViewTituloDescricao = textViewTituloDescricao;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDescricaoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDescricaoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_descricao, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDescricaoBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_Return;
      Button buttonReturn = ViewBindings.findChildViewById(rootView, id);
      if (buttonReturn == null) {
        break missingId;
      }

      id = R.id.textView_Descricao;
      TextView textViewDescricao = ViewBindings.findChildViewById(rootView, id);
      if (textViewDescricao == null) {
        break missingId;
      }

      id = R.id.textView_titulo_Descricao;
      TextView textViewTituloDescricao = ViewBindings.findChildViewById(rootView, id);
      if (textViewTituloDescricao == null) {
        break missingId;
      }

      return new ActivityDescricaoBinding((ConstraintLayout) rootView, buttonReturn,
          textViewDescricao, textViewTituloDescricao);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
