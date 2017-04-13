package com.rommelpicon.desarrolloaplicaciondos;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.DatePickerDialog;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity  {

    TextInputEditText tximputNombre;
    TextInputEditText tximputApellidos;
    TextInputEditText tximputTelefono;
    TextInputEditText tximputEmail;
    TextInputEditText tximputDescripcion;
    TextView tvFechaInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tximputNombre=(TextInputEditText)findViewById(R.id.tximputNombre);
        tximputApellidos=(TextInputEditText)findViewById(R.id.tximputApellidos);
        tvFechaInicio=(TextView)findViewById(R.id.tvFechaInicio);
        tximputTelefono=(TextInputEditText)findViewById(R.id.tximputTelefono);
        tximputEmail=(TextInputEditText)findViewById(R.id.tximputEmail);
        tximputDescripcion=(TextInputEditText)findViewById(R.id.tximputDescripcion);


        Button buttonsiguiente = (Button)findViewById(R.id.buttonsiguiente);


        buttonsiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,DetalleDatos.class);

                String nombre = tximputNombre.getText().toString();
                String apellido = tximputApellidos.getText().toString();
                String fecha = tvFechaInicio.getText().toString();
                String telefono= tximputTelefono.getText().toString();
                String email = tximputEmail.getText().toString();
                String descripcion = tximputDescripcion.getText().toString();

                intent.putExtra(getResources().getString(R.string.putnombres),nombre);
                intent.putExtra(getResources().getString(R.string.putapellido),apellido);
                intent.putExtra(getString(R.string.putfecha),fecha);
                intent.putExtra(getResources().getString(R.string.puttelefono),telefono);
                intent.putExtra(getResources().getString(R.string.putemail),email);
                intent.putExtra(getResources().getString(R.string.putdescripcion),descripcion);

                startActivity(intent);

        }});

      }


    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        TextView tvFechaInicio;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }


        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user

            tvFechaInicio =(TextView)getActivity().findViewById(R.id.tvFechaInicio);
            tvFechaInicio.setText(String.valueOf(day)+ "/" + String.valueOf(month+1) + "/" + String.valueOf(year));

        }

    }

    public void showDatePickerDialog(View v) {
       DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
   }

}

