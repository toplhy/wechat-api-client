package wechat.api.client.ssl;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;


public class CustomizeX509TrustManager implements X509TrustManager {

    public void checkClientTrusted(X509Certificate[] chain, String authType) {
    }

    public void checkServerTrusted(X509Certificate[] chain, String authType) {
        //System.out.println("cert: " + chain[0].toString() + ", authType: " + authType);
    }

    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}

