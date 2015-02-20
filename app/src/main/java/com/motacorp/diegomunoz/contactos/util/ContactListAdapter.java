package com.motacorp.diegomunoz.contactos.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.motacorp.diegomunoz.contactos.R;

import java.util.List;

/**
 * Created by diegomunoz on 20-02-15.
 */
public class ContactListAdapter extends ArrayAdapter<Contacto> {
    private Activity ctx;

    public ContactListAdapter(Activity context, List<Contacto> contactos){
        super(context, R.layout.listview_item, contactos);
        this.ctx = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if ( view == null ) {
            view = ctx.getLayoutInflater().inflate(R.layout.listview_item, parent, false);
        }
        Contacto actual = this.getItem(position);
        iniciarCamposTexto(view, actual);
        return view;
    }

    private void iniciarCamposTexto(View view, Contacto actual) {
        TextView textView = (TextView)view.findViewById(R.id.viewNombre);
        TextView.setText(actual.getNombre());
        TextView textView = (TextView)view.findViewById(R.id.viewTelefono);
        TextView.setText(actual.getTelefono());
        TextView textView = (TextView)view.findViewById(R.id.viewEmail);
        TextView.setText(actual.getEmail());
        TextView textView = (TextView)view.findViewById(R.id.viewDireccion);
        TextView.setText(actual.getDireccion());
    }


}
