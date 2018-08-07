package wechat.api.client

import grails.converters.JSON
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.http.ResponseEntity

/**
 * 二维码
 */
@Transactional
class WechatQrCodeService extends WechatBaseService{

    /**
     * 创建临时二维码
     * @param senceType 场景类型（INT 整形/STR 字符串）
     * @param senceValue
     * @param expireSeconds 过期时间，以秒为单位， 最大不超过2592000, 默认30
     * @return
     */
    def createQrCode(senceType, senceValue, expireSeconds=30) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def actionName = senceType?.toString()?.equals("id")?"QR_SCENE":"QR_STR_SCENE"
        def json = ""
        if(senceType?.toString()?.equals("INT")) {
            json = ["expire_seconds": expireSeconds, "action_name": actionName, "action_info":["scene":["scene_id": senceValue]]] as JSONObject
        }
        if(senceType?.toString()?.equals("STR")) {
            json = ["expire_seconds": expireSeconds, "action_name": actionName, "action_info":["scene":["scene_str": senceValue]]] as JSONObject
        }
        if(json) {
            def url = config?.createQrCodeUrl?.toString()?.replace("+++", atoken?.toString())
            def result = JSON.parse(this.getRestTemplate().postForObject(url, json, String.class))
            result
        }
    }

    /**
     * 创建永久二维码
     * @param senceType  场景类型（INT 整形/STR 字符串）
     * @param senceValue
     * @return
     */
    def createLimitQrCode(senceType, senceValue) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def actionName = senceType?.toString()?.equals("id")?"QR_LIMIT_SCENE":"QR_LIMIT_STR_SCENE"
        def json = ""
        if(senceType?.toString()?.equals("INT")) {
            json = ["action_name": actionName, "action_info":["scene":["scene_id": senceValue]]] as JSONObject
        }
        if(senceType?.toString()?.equals("STR")) {
            json = ["action_name": actionName, "action_info":["scene":["scene_str": senceValue]]] as JSONObject
        }
        if(json) {
            def url = config?.createQrCodeUrl?.toString()?.replace("+++", atoken?.toString())
            def result = JSON.parse(this.getRestTemplate().postForObject(url, json, String.class))
            result
        }
    }

    /**
     * todo 测试
     * 通过ticket换取二维码
     * @param ticket
     * @return
     */
    def getQrCode(ticket) {
        def config = this.getWechatConfig()
        def url = config?.getQrCodeUrl?.toString()?.replace("---", ticket?.toString())
        ResponseEntity<String> responseEntity = this.getRestTemplate().getForEntity(url, String.class)
        def fileMap = [:]
        fileMap.filetype = responseEntity?.getHeaders()?.getContentType()
        fileMap.length = responseEntity?.getHeaders()?.getContentLength()
        fileMap.bytes = responseEntity?.getBody()?.getBytes()
        fileMap
    }
}
