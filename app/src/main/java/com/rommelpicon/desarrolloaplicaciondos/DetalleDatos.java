package com.rommelpicon.desarrolloaplicaciondos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleDatos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle_datos);

        Bundle parametros   = getIntent().getExtras();
        String nombre       = parametros.getString(getResources().getString(R.string.putnombres));
        String apellido     = parametros.getString(getResources().getString(R.string.putapellido));
        String calendar = parametros.getString(getResources().getString(R.string.putfecha));
        String telefono     = parametros.getString(getResources().getString(R.string.puttelefono));
        String email        = parametros.getString(getResources().getString(R.string.putemail));
        String descripcion  = parametros.getString(getResources().getString(R.string.putdescripcion));



        TextView tvNombreDestino = (TextView)findViewById(R.id.tvNombreDestino);
        tvNombreDestino.setText(nombre);
        TextView tvApellidoDestino = (TextView)findViewById(R.id.tvApellidoDestino);
        tvApellidoDestino.setText(apellido);
        TextView tvFechaDestino = (TextView)findViewById(R.id.tvFechaDestino);
        tvFechaDestino.setText(calendar);
        TextView tvTelefonoDestino = (TextView)findViewById(R.id.tvTelefonoDestino);
        tvTelefonoDestino.setText(telefono);
        TextView tvEmailDestino = (TextView)findViewById(R.id.tvEmailDestino);
        tvEmailDestino.setText(email);
        TextView tvDescripcionDestino = (TextView)findViewById(R.id.tvDescripcionDestino);
        tvDescripcionDestino.setText(descripcion);

        Button buttonEditarDatos =(Button)findViewById(R.id.buttonEditarDatos);

        buttonEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(DetalleDatos.this,MainActivity.class);
                //startActivity(intent);
                onBackPressed();//para que regresar a la actvidad anterior sin eliminar los datos
            }
        });

    }
}
