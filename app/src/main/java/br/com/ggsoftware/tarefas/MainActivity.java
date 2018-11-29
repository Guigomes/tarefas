package br.com.ggsoftware.tarefas;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.BreakIterator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import br.com.ggsoftware.tarefas.dao.DaoSession;
import br.com.ggsoftware.tarefas.dao.Tarefa;
import br.com.ggsoftware.tarefas.dao.TarefaDao;

public class MainActivity extends AppCompatActivity {

    EditText edtNomeTarefa;
    static EditText edtDataInicio;

    static EditText edtDataFim;

    Spinner spinnerPeriodo;
    Spinner spinnerPeriodicidade;

    DaoSession daoSession;
    TarefaDao tarefaDAO;

    static SimpleDateFormat sdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         daoSession = ((App) getApplication()).getDaoSession();
         tarefaDAO = daoSession.getTarefaDao();

        sdf = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt-BR"));
        /*
        Tarefa tarefa = new Tarefa();
        tarefa.setNome("Regar as plantas");

        tarefa.setDataFim(new Date());
        tarefa.setDataInicio(new Date());
        tarefa.setDataInclusao(new Date());
        tarefa.setDataProximoDiaTarefa(new Date());
        tarefa.setValorPeridiocidade(2);
        tarefa.setPeriodicidade(1);
        tarefa.setPeriodo(2);

        //tarefaDAO.insert(tarefa);
*/
        edtNomeTarefa = findViewById(R.id.edtNomeTarefa);

        edtDataInicio = findViewById(R.id.edtDataInicio);

        edtDataFim = findViewById(R.id.edtDataFim);

        edtDataInicio.setText(sdf.format(new Date()));

        edtDataInicio.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    DialogFragment newFragment = new DatePickerFragmentInicio();
                    newFragment.show(getSupportFragmentManager(), "datePicker");
                }
            }

        });
        edtDataFim.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    DialogFragment newFragment = new DatePickerFragmentFim();
                    newFragment.show(getSupportFragmentManager(), "datePicker2");
                }
            }

        });


         spinnerPeriodo = (Spinner) findViewById(R.id.spinner_periodo_tarefa);

         spinnerPeriodicidade = (Spinner) findViewById(R.id.spinner_periodicidade_tarefa);

        ArrayAdapter<CharSequence> adapterPeriodicidade = ArrayAdapter.createFromResource(this,
                R.array.periodicidade, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> adapterPeriodo = ArrayAdapter.createFromResource(this,
                R.array.periodos, android.R.layout.simple_spinner_item);

        adapterPeriodicidade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adapterPeriodo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        spinnerPeriodo.setAdapter(adapterPeriodo);

        spinnerPeriodicidade.setAdapter(adapterPeriodicidade);

        Tarefa a  = tarefaDAO.loadByRowId(1);
        if(a != null){
            Toast.makeText(getApplicationContext(), a.getNome(), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "null", Toast.LENGTH_SHORT).show();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void criarTarefa(View v) throws ParseException {

        String nomeTarefa = edtNomeTarefa.getText().toString();

        Integer periodoTarefa = spinnerPeriodo.getSelectedItemPosition();

        Integer periodicidadeTarefa = spinnerPeriodicidade.getSelectedItemPosition();


        String dataFim = edtDataFim.getText().toString();

        String dataInicio = edtDataInicio.getText().toString();

        Calendar calendarInicio = Calendar.getInstance();

        Calendar calendarFim = Calendar.getInstance();

        calendarInicio.setTime(sdf.parse(dataInicio));

        Tarefa novaTarefa = new Tarefa();




        novaTarefa.setNome(nomeTarefa);
        novaTarefa.setPeriodo(periodoTarefa);
        novaTarefa.setPeriodicidade(periodicidadeTarefa);
        novaTarefa.setDataInicio(calendarInicio.getTime());
        novaTarefa.setDataInclusao(new Date());
                if(dataFim != null && dataFim.length() > 0){


        calendarFim.setTime(sdf.parse(dataFim));
                    novaTarefa.setDataFim(calendarFim.getTime());
    }

        tarefaDAO.insert(novaTarefa);
        Log.i("TESTE", novaTarefa.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class DatePickerFragmentInicio extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

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
            final Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, day);

            edtDataInicio.setText(sdf.format(c.getTime()));
            // Do something with the date chosen by the user
        }
    }

    public static class DatePickerFragmentFim extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {



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

            final Calendar c = Calendar.getInstance();
             c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
             c.set(Calendar.DAY_OF_MONTH, day);

            edtDataFim.setText(sdf.format(c.getTime()));

            // Do something with the date chosen by the user
        }
    }

}
