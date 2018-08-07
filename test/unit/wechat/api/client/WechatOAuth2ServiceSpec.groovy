package wechat.api.client

import grails.test.mixin.TestFor
import spock.lang.Specification
import wechat.api.client.enums.OAuth2Scope

@TestFor(WechatOAuth2Service)
class WechatOAuth2ServiceSpec extends Specification {

    WechatOAuth2Service wechatOAuth2Service

    def setup() {
        wechatOAuth2Service = mockService(WechatOAuth2Service)
    }

    def cleanup() {
    }

    /**
     * 获取网页授权链接
     */
    void testGetOAuth2Url() {
        def result = wechatOAuth2Service.getOAuth2Url("http://www.baidu.com", OAuth2Scope.SNSAPI_BASE, "123456")
        println "testGetOAuth2Url result: ${result}"
        expect: result
    }

    /**
     * 通过code换取网页授权access_token
     */
    void testGetOAuth2AccessToken() {
        def result = wechatOAuth2Service.getOAuth2AccessToken("")
        println "testGetOAuth2AccessToken result: ${result}"
        expect: result
    }

    /**
     * 刷新access_token
     */
    void testRefreshAccessToken() {
        def result = wechatOAuth2Service.refreshAccessToken("")
        println "testRefreshAccessToken result: ${result}"
        expect: result
    }

    /**
     * 获取用户信息
     */
    void testGetUserInfo() {
        def result = wechatOAuth2Service.getUserInfo("", "")
        println "testGetUserInfo result: ${result}"
        expect: result
    }

    /**
     * 检验授权凭证（access_token）是否有效
     */
    void testValidateAccessToken() {
        def result = wechatOAuth2Service.validateAccessToken("", "")
        println "testValidateAccessToken result: ${result}"
        expect: result
    }
}
