package arduino;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;
import at.abraxas.amarino.Amarino;
import com.example.testearduino.R;

public class ControleRemoto extends Activity implements OnClickListener {

	private static final String DEVICE_ADDRESS = "98:D3:31:B3:68:A9";
	 
	private ToggleButton tbOnOff;
	private int on,off;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_controle);
        
        // Chamada da API Amarino para conexão com o device:
		Amarino.connect(this, DEVICE_ADDRESS);
 
		tbOnOff = (ToggleButton) findViewById(R.id.tbOnOff);
        tbOnOff.setOnClickListener(this);
    }	

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
		
		// Interrompe o serviço Amarino:
		Amarino.disconnect(this, DEVICE_ADDRESS);
	}
 
	public void onClick(View arg0) {
 
		// Ao clicar no botão:
		if(tbOnOff.isChecked()){
			// Liga o LED:
			Amarino.sendDataToArduino(this, DEVICE_ADDRESS, 'O', 1);
		}else {
			// Desliga o LED:
			Amarino.sendDataToArduino(this, DEVICE_ADDRESS, 'F', 0);
		}
	}

}