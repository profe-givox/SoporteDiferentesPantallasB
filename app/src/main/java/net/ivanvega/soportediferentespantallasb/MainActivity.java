package net.ivanvega.soportediferentespantallasb;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.contenedor_pequeno) != null &&
                getSupportFragmentManager().findFragmentById(R.id.contenedor_pequeno) ==null
           ){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.contenedor_pequeno,
                            SelectorFragment.class, null)
            .commit();
        }




    }

    public void mostrarDetalle(int posLibroSelectd) {
        DetalleFragment detalleFragment;

        detalleFragment =(DetalleFragment)
                getSupportFragmentManager().findFragmentById(R.id.detalle_fragment);

        if (detalleFragment!=null){
            detalleFragment.setInfoLibro(posLibroSelectd)   ;
        }else{

            detalleFragment = new DetalleFragment();

            Bundle param = new Bundle();
            param.putInt(DetalleFragment.ARG_LIBRO_POS, posLibroSelectd );

            detalleFragment.setArguments(param);

            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.contenedor_pequeno, detalleFragment, null )
                    .addToBackStack(null)
                    .commit();
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if( item.getItemId() == R.id.menu_preferencias){
            //Menu para preferencias
            return true;
        }else if (item.getItemId() == R.id.menu_ultimo){
            irUltimoVisitado();
        }


        return super.onOptionsItemSelected(item);
    }

    private void irUltimoVisitado() {

    }
}