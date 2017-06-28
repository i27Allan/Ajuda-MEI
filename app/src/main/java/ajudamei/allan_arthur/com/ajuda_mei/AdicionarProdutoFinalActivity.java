package ajudamei.allan_arthur.com.ajuda_mei;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AdicionarProdutoFinalActivity extends Activity {
    private DatabaseMateriaPrima db;
    private DatabaseProdutoFinal db2;
    private static final int CAMERA_REQUEST = 1;
    private static final int PICK_FROM_GALLERY = 2;

    private Button goToMatPrima;
    private Button confirmarAdd;
    private Button tirarFoto;
    private Button escolherFoto;
    private ImageView img;
    private EditText nome;
    private EditText quantidade;
    private EditText preco;
    private EditText tamanho;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_produto_final);

        db = new DatabaseMateriaPrima(this);
        db2 = new DatabaseProdutoFinal(this);
        confirmarAdd = (Button) findViewById(R.id.bt_adicionar_mat_prima_ao_estoque);
        tirarFoto = (Button) findViewById(R.id.bt_tirar_foto);
        escolherFoto = (Button) findViewById(R.id.bt_escolher_foto);
        nome = (EditText) findViewById(R.id.editTextNome);
        quantidade = (EditText) findViewById(R.id.editTextQuantidade);
        preco = (EditText) findViewById(R.id.editTextPreco);
        tamanho = (EditText) findViewById(R.id.editTextTamanho);
        img = (ImageView) findViewById(R.id.img_view_foto);
        goToMatPrima = (Button) findViewById(R.id.bt_escolher_mat_prima);


        goToMatPrima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdicionarProdutoFinalActivity.this, EscolherMatPrimaActivity.class);
                startActivity(intent);

            }
        });
        confirmarAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable drawable = (BitmapDrawable) img.getDrawable();
                Bitmap bitmap = drawable.getBitmap();


                //db.insert(aux);
                Intent intent = new Intent(AdicionarProdutoFinalActivity.this, EscolherProdutoFinalActivity.class);
                Toast.makeText(getApplicationContext(), "Item adicionado!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        tirarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callCamera();

            }
        });

        escolherFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callGallery();

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode != RESULT_OK) {
            return;
        }

        if(requestCode == CAMERA_REQUEST){
            Bundle extras = data.getExtras();

            if (extras != null) {
                Bitmap yourImage = extras.getParcelable("data");
                ImageView img = (ImageView)findViewById(R.id.img_view_foto);
                img.setImageBitmap(yourImage);

            }


        } else if(requestCode == PICK_FROM_GALLERY){
            Bundle extras2 = data.getExtras();

            if (extras2 != null) {
                Bitmap yourImage = extras2.getParcelable("data");

                ImageView img = (ImageView)findViewById(R.id.img_view_foto);
                img.setImageBitmap(yourImage);

            }
        } else {
            return;
        }

    }


    /**
     * open camera method
     */
    public void callCamera() {
        Intent cameraIntent = new Intent(
                android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        //cameraIntent.putExtra("crop", "true");
        //cameraIntent.putExtra("aspectX", 0);
        //cameraIntent.putExtra("aspectY", 0);
        //cameraIntent.putExtra("outputX", 200);
        //cameraIntent.putExtra("outputY", 150);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

    }

    /**
     * open gallery method
     */

    public void callGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 0);
        intent.putExtra("aspectY", 0);
        intent.putExtra("outputX", 200);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(
                Intent.createChooser(intent, "Complete action using"),
                PICK_FROM_GALLERY);

    }
}