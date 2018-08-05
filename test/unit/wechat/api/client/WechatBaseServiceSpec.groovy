package wechat.api.client

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(WechatBaseService)
class WechatBaseServiceSpec extends Specification {

    WechatBaseService wechatBaseService

    def setup() {
        wechatBaseService = mockService(WechatBaseService)
    }

    def cleanup() {
    }

    def testGetWechatConfig() {
        def result = wechatBaseService.getWechatConfig()
        println "testGetWechatConfig result: ${result}"
        expect: result && result.getAccessTokenUrl
    }

    def testGetAccessToken() {
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
        def longUrl = 'https://github.com/toplhy/wechat-api-client'
        def result = wechatBaseService.getShortUrl(longUrl)
        println "testGetShortUrl result: ${result}"
        expect: result && result.errcode == 0
    }
}
