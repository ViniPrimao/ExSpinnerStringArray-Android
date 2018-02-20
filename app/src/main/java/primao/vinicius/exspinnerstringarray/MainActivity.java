package primao.vinicius.exspinnerstringarray;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


    public class MainActivity extends AppCompatActivity {

        //widgets
        private Spinner spSexo;
        private Button btnOK;
        private ImageView ivSexo;
        //ArrayAdapter global
        private ArrayAdapter<String> adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //Refs
            spSexo = findViewById(R.id.ma_sp_sexo);
            btnOK = findViewById(R.id.ma_btn_ok);
            ivSexo = findViewById(R.id.ma_iv_sexo);

            //Criando arraylist
            ArrayList<String> arraySexo = new ArrayList<>();
            arraySexo.add("Selecione");
            arraySexo.add("Masculino");
            arraySexo.add("Feminino");
            arraySexo.add("Outros");

            //Setar o array no adapter
            adapter = new ArrayAdapter<String>(
                    MainActivity.this,
                    android.R.layout.simple_dropdown_item_1line,
                    arraySexo);

            //Setar o adapter na Spinner
            spSexo.setAdapter(adapter);

            spSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if(position!=0){
                        String sexo = spSexo.getSelectedItem().toString();

                        if(sexo.equalsIgnoreCase("masculino")){
                            Picasso
                                    .with(MainActivity.this)
                                    .load("https://image.freepik.com/vetores-gratis/icone-de-usuario-do-sexo-masculino_17-810120247.jpg")
                                    .into(ivSexo);
                        }else{
                            Picasso
                                    .with(MainActivity.this)
                                    .load("https://images.onlinelabels.com/images/clip-art/dagobert83/dagobert83_female_user_icon.png")
                                    .into(ivSexo);
                        }

                        Toast.makeText(getBaseContext(),
                                "Sexo escolhido: "+sexo,
                                Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


            btnOK.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(spSexo.getSelectedItemPosition()==0){
                        Toast.makeText(getBaseContext(),
                                "Selecione um sexo!",
                                Toast.LENGTH_SHORT).show();
                    }else {
                        String sexo = spSexo.getSelectedItem().toString();
                        Toast.makeText(getBaseContext(),
                                "Sexo escolhido: "+sexo,
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }//fecha oncreate
    }//fecha classe