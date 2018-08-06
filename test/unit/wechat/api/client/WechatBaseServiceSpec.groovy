package wechat.api.client

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * WechatBaseService test class
 */
@TestFor(WechatBaseService)
class WechatBaseServiceSpec extends Specification {

    WechatBaseService wechatBaseService

    def setup() {
        wechatBaseService = mockService(WechatBaseService)
    }

    def cleanup() {
    }

    void testGetWechatConfig() {
        def result = wechatBaseService.getWechatConfig()
        println "testGetWechatConfig result: ${result}"
        expect: result && result.getAccessTokenUrl
    }

    void testGetAccessToken() {
        def result = wechatBaseService.getAccessToken()
        println "testGetAccessToken result: ${result}"
        expect: result
    }

    void testGetWechatServerIps() {
        def result = wechatBaseService.getWechatServerIps()
        println "testGetWechatServerIps result: ${result}"
        expect: result && result.ip_list
    }

    void testGetShortUrl(){
        def longUrl = 'https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1445241432'
        def result = wechatBaseService.getShortUrl(longUrl)
        println "testGetShortUrl result: ${result}"
        expect: result && result.errcode == 0
    }
}
