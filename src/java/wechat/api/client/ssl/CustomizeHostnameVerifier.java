package wechat.api.client.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class CustomizeHostnameVerifier implements HostnameVerifier {

    public boolean verify(String hostname, SSLSession session) {
        //System.out.println("Warning: URL Host: " + hostname + " vs. " + session.getPeerHost());
        return true;
    }
}

