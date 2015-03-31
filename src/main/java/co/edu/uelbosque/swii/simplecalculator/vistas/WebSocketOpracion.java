package co.edu.uelbosque.swii.simplecalculator.vistas;
 
import javax.faces.application.FacesMessage;
import org.primefaces.push.RemoteEndpoint;
import org.primefaces.push.annotation.OnMessage;
import org.primefaces.push.annotation.OnOpen;
import org.primefaces.push.annotation.PushEndpoint;
import org.primefaces.push.annotation.Singleton;
import org.primefaces.push.impl.JSONEncoder;
 
@PushEndpoint("/operacion")
@Singleton
public class WebSocketOpracion {

    public WebSocketOpracion() {

        boolean ok=true;
    }
    
    @OnOpen
    public void open(RemoteEndpoint r){
        boolean ok=true;
    }
         
    @OnMessage(encoders = {JSONEncoder.class})
    public String onMessage(String count) {
        return count;
    }
 
}