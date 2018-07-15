package wechat.api.client.utils

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONElement
import wechat.api.client.exception.WeChatException
import wechat.api.client.ssl.CustomizeHostnameVerifier
import wechat.api.client.ssl.CustomizeX509TrustManager

import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager

class HttpClient {

    private static initSSLSetting=false

    static JSONElement postDataViaHttps(address, data, method, cookie){
        try{
            if(!initSSLSetting){
                SSLContext sslContext = SSLContext.getInstance("TLS") //或SSL
                X509TrustManager[] xtmArray =[new CustomizeX509TrustManager()]
                sslContext.init(null, xtmArray, new java.security.SecureRandom())
                if (sslContext != null) {
                    HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory())
                }
                HttpsURLConnection.setDefaultHostnameVerifier(new CustomizeHostnameVerifier())
                initSSLSetting=true
            }

            //
            URL url = new URL(address)
            HttpsURLConnection conn = url.openConnection()
            conn.setRequestMethod(method)
            conn.setDoOutput(true)
            if(cookie!=null){
                conn.setRequestProperty("Cookie", cookie)
            }
            conn.outputStream.withWriter('utf-8'){writer->
                writer.write(data)
            }
            def result =  conn.inputStream.getText('utf-8')
            return JSON.parse(result)
        } catch (Exception e) {
            throw new WeChatException("wechat request failed: ${e}")
        }
    }
}
