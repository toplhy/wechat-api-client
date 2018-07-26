package wechat.api.client.utils

import com.qq.weixin.mp.aes.WXBizMsgCrypt

/**
 * 消息处理工具类
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
     * @param token
     * @param aesKey
     * @param appId
     * @param timestamp
     * @param nonce
     * @return
     */
    def static encode(msg, token, aesKey, appId, timestamp, nonce) {
        def mc = new WXBizMsgCrypt(token?.toString(), aesKey?.toString(), appId?.toString())
        return mc.encryptMsg(msg?.toString(), timestamp?.toString(), nonce?.toString())
    }

    /**
     * 解密
     */
    def static decode() {

    }

}
