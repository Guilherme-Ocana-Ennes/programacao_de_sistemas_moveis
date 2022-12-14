// Generated by view binder compiler. Do not edit!
package com.api.trabalhofinal.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
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

public final class ActivityConvidadosBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonReturn;

  @NonNull
  public final ListView listview;

  @NonNull
  public final TextView textViewListaConvidados;

  @NonNull
  public final TextView textViewTituloConvidados;

  private ActivityConvidadosBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button buttonReturn, @NonNull ListView listview,
      @NonNull TextView textViewListaConvidados, @NonNull TextView textViewTituloConvidados) {
    this.rootView = rootView;
    this.buttonReturn = buttonReturn;
    this.listview = listview;
    this.textViewListaConvidados = textViewListaConvidados;
    this.textViewTituloConvidados = textViewTituloConvidados;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityConvidadosBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityConvidadosBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_convidados, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityConvidadosBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_Return;
      Button buttonReturn = ViewBindings.findChildViewById(rootView, id);
      if (buttonReturn == null) {
        break missingId;
      }

      id = R.id.listview;
      ListView listview = ViewBindings.findChildViewById(rootView, id);
      if (listview == null) {
        break missingId;
      }

      id = R.id.textView_lista_convidados;
      TextView textViewListaConvidados = ViewBindings.findChildViewById(rootView, id);
      if (textViewListaConvidados == null) {
        break missingId;
      }

      id = R.id.textView_titulo_convidados;
      TextView textViewTituloConvidados = ViewBindings.findChildViewById(rootView, id);
      if (textViewTituloConvidados == null) {
        break missingId;
      }

      return new ActivityConvidadosBinding((ConstraintLayout) rootView, buttonReturn, listview,
          textViewListaConvidados, textViewTituloConvidados);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
