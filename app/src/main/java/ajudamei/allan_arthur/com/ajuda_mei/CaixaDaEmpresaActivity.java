package ajudamei.allan_arthur.com.ajuda_mei;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CaixaDaEmpresaActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caixa_da_empresa);

        final Button bt1 = (Button) findViewById(R.id.bt_pagamento_boleto);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CaixaDaEmpresaActivity.this, PagamentoBoletoActivity.class);
                startActivity(intent);
            }
        });

        final Button bt2 = (Button) findViewById(R.id.bt_venda_produto);
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CaixaDaEmpresaActivity.this, VendaProdutoActivity.class);
                startActivity(intent);
            }
        });

        final Button bt3 = (Button) findViewById(R.id.bt_entrada_recursos);
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CaixaDaEmpresaActivity.this, EntradaRecursosActivity.class);
                startActivity(intent);
            }
        });

        final Button bt4 = (Button) findViewById(R.id.bt_aquisicao_mat_prima);
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CaixaDaEmpresaActivity.this, AquisicaoMatPrimaActivity.class);
                startActivity(intent);
            }
        });
    }
}
