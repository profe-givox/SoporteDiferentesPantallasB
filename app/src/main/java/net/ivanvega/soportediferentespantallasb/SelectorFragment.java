package net.ivanvega.soportediferentespantallasb;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerViewLibros;
    private MainActivity activity;

    public SelectorFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectorFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectorFragment newInstance(String param1, String param2) {
        SelectorFragment fragment = new SelectorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity){
           this.activity = (MainActivity)context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(
                R.layout.selector_fragment_layout,
                container, false);

        TextView label =
                layout.findViewById(R.id.lblFrag);

        label.setText("Esto es un fragmento con comportameinto");


        recyclerViewLibros = layout.findViewById(R.id.recyclerView);

        MiAdaptadorPersonaliza miAdaptadorPersonaliza
                = new MiAdaptadorPersonaliza(Libro.ejemplosLibros());

        miAdaptadorPersonaliza.setOnClickItemListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int posLibroSelectd = recyclerViewLibros.getChildAdapterPosition(view);
                Toast.makeText(getActivity(),"item selected: "+ posLibroSelectd  ,
                        Toast.LENGTH_LONG).show();
                SelectorFragment.this.activity.mostrarDetalle(posLibroSelectd);

            }
        });

        miAdaptadorPersonaliza.setOnLongClickItemListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                Toast.makeText(activity,
                        "Esto fue un presionado largo",
                        Toast.LENGTH_LONG).show();

                return false;
            }
        });

        recyclerViewLibros.setAdapter(miAdaptadorPersonaliza);

        RecyclerView.LayoutManager layoutManager
                 = new GridLayoutManager(getActivity(), 2);

        recyclerViewLibros.setLayoutManager(layoutManager);

        return layout;

    }
}