package com.motacorp.diegomunoz.contactos;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.motacorp.diegomunoz.contactos.util.Contacto;
import com.motacorp.diegomunoz.contactos.util.TextChangedListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private EditText txtNombre;
    private EditText txtTelefono;
    private EditText txtMail;
    private EditText txtDireccion;
    private Button  btnAgregar;
    private List<Contacto> contactos = new ArrayList<Contacto>();
    private ListView contactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciaComponente();
        iniciarTab();
    }

    private void iniciaComponente(){
        txtNombre    = (EditText)findViewById(R.id.txtNombre);
        txtTelefono  = (EditText)findViewById(R.id.txtTelefono);
        txtMail      = (EditText)findViewById(R.id.txtEmail);
        txtDireccion = (EditText)findViewById(R.id.txtDireccion);
        contactListView = (ListView)findViewById(R.id.listView);
        txtNombre.addTextChangedListener(new TextChangedListener(){
            @Override
            public void onTextChanged(CharSequence seq, int i1, int i2, int i3) {
                btnAgregar = (Button)findViewById(R.id.btnAgregar);
                btnAgregar.setEnabled(!seq.toString().trim().isEmpty());
            }
        });

    }

    private void iniciarTab(){
        TabHost tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("tab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Crear");
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("tab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Lista");
        tabHost.addTab(spec);

    }

    public void onClick(View view) {
        agregarContacto(
                txtNombre.getText().toString();
                txtTelefono.getText().toString();
                txtMail.getText().toString();
                txtMail.getText().toString();
        );
        String mensaje = String.format("%s ha sido agregado a la lista !!", txtNombre.getText());
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
        btnAgregar.setEnabled(false);
        iniciarLista();
        limpiarCampo();
    }

    private void iniciarLista(){

    }

    private void agregarContacto(String nombre, String telefono, String email, String direccion){

    }

    private void limpiarCampo(){
        txtNombre.getText().clear();
        txtTelefono.getText().clear();
        txtMail.getText().clear();
        txtDireccion.getText().clear();
        txtNombre.requestFocus();
    }
}
