package wechat.api.client.utils

import com.qq.weixin.mp.aes.WXBizMsgCrypt
import wechat.api.client.exception.WeChatException

/**
 * 消息处理工具类
 * 异常java.security.InvalidKeyException:illegal Key Size的解决方案
 * 在官方网站下载JCE无限制权限策略文件（JDK7的下载地址：
 * http://www.oracle.com/technetwork/java/javase/downloads/jce-7-download-432124.html
 * 下载后解压，可以看到local_policy.jar和US_export_policy.jar以及readme.txt
 * 如果安装了JRE，将两个jar文件放到%JRE_HOME%\lib\security目录下覆盖原来的文件
 * 如果安装了JDK，将两个jar文件放到%JDK_HOME%\jre\lib\security目录下覆盖原来文件
 */
class MessageUtils {

    /**
     * map 转 xml
     */
     def static mapToXmlString(map) {
        def sb = new StringBuffer();
        sb.append("<xml>");
        for (String key : map.keySet()) {
            sb.append("<${key}><![CDATA[${map.get(key)}]]></${key}>");
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 加密
     * @param msg
     * @param config
     * @param timestamp
     * @param nonce
     * @return
     */
    def static encode(msg, config, timestamp, nonce) {
        def result
        try {
            def mc = new WXBizMsgCrypt(config?.token?.toString(), config?.encodingAESKey?.toString(), config?.appId?.toString())
            result = mc.encryptMsg(msg?.toString(), timestamp?.toString(), nonce?.toString())
        } catch(Exception e) {
            throw new WeChatException("exception occur while encode message", e)
        }
        return result
    }

    /**
     * 解密
     * @param msg
     * @param config
     * @param msgSignature
     * @param timeStamp
     * @param nonce
     */
    def static decode(msg, config, msgSignature, timestamp, nonce) {
        def result
        try{
            def mc = new WXBizMsgCrypt(config?.token?.toString(), config?.encodingAESKey?.toString(), config?.appId?.toString())
            result =  mc.decryptMsg(msgSignature?.toString(), timestamp?.toString(), nonce?.toString(), msg?.toString())
            println result
        } catch(Exception e) {
            throw new WeChatException("exception occur while decode message", e)
        }
        return result
    }
}
