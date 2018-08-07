package wechat.api.client

import grails.test.mixin.TestFor
import org.codehaus.groovy.grails.web.json.JSONObject
import spock.lang.Specification

/**
 * WechatMessageService class test
 */
@TestFor(WechatMessageService)
class WechatMessageServiceSpec extends Specification {

    WechatMessageService wechatMessageService

    def setup() {
        wechatMessageService = mockService(WechatMessageService)
    }

    def cleanup() {
    }

    /**
     * 设置所属行业
     */
    void testSetIndustry() {
        def result = wechatMessageService.setIndustry(4,1)
        println "testSetIndustry result: ${result}"
        expect: result && result.errcode == 0
    }

    /**
     * 获取设置的行业信息
     */
    void testGetIndustry() {
        def result = wechatMessageService.getIndustry()
        println "testGetIndustry result: ${result}"
        expect: result
    }

    /**
     * 获得模板ID
     */
    void testGetTemplateIds() {
        def result = wechatMessageService.getTemplateIds("TM00015")
        println "testGetTemplateIds result: ${result}"
        expect: result
    }

    /**
     * 获取已添加至帐号下模板列表
     */
    void testGetPrivateTemplates() {
        def result = wechatMessageService.getPrivateTemplates()
        println "testGetPrivateTemplates result: ${result}"
        expect: result
    }

    /**
     * 删除已添加至账号的模板
     */
    void testDeletePrivateTemplate() {
        def result = wechatMessageService.deletePrivateTemplate("fvakcAXUkSZCjENuXTghe4CLxm8vIJwmgB9vFgzTxv4")
        println "testDeletePrivateTemplate result: ${result}"
        expect: result
    }

    /**
     * 发送模板消息
     */
    void testSendTemplateMsg() {
        def map = [:]
        map.touser = "oKVN01dq09qGVIQVjthHox_3JCf8"
        map.template_id = "fvakcAXUkSZCjENuXTghe4CLxm8vIJwmgB9vFgzTxv4"
        map.url = "https://www.baidu.com"
        def data = [:]
        data.first = ["value":"订单支付成功（测试）"]
        data.orderMoneySum = ["value":"￥20000000.00"]
        data.orderProductName = ["value":"房子"]
        data.Remark = ["value":"如有问题请直接在微信留言"]
        map.data = data
        def result = wechatMessageService.sendTemplateMsg(map as JSONObject)
        println "testSendTemplateMsg result: ${result}"
        expect: result
    }
}
