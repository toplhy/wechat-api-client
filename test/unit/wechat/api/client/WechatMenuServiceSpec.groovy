package wechat.api.client

import grails.converters.JSON
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * WechatMenuService class test
 */
@TestFor(WechatMenuService)
class WechatMenuServiceSpec extends Specification {

    WechatMenuService wechatMenuService
    String menuStr = """{"button":[{"type":"view","name":"12309","url":"https://www.12309.gov.cn"},{"name":"搜索","sub_button":[{"type":"view","name":"搜搜","url":"http://www.soso.com/"},{"type":"view","name":"百度一下","url":"https://www.baicu.com",},{"type":"view","name":"360","url":"https://hao.360.cn/"}]}]}"""
    String conditionalMenuStr = """{"button":[{"type":"view","name":"12309","url":"https://www.12309.gov.cn"},{"name":"搜索吧","sub_button":[{"type":"view","name":"百度一下","url":"https://www.baicu.com",},{"type":"view","name":"360","url":"https://hao.360.cn/"}]}],"matchrule":{"country":"中国"}}"""

    def setup() {
        wechatMenuService = mockService(WechatMenuService)
    }

    def cleanup() {
    }

    /**
     * 自定义菜单创建
     */
    void testCreateMenu() {
        def menuJson = JSON.parse(menuStr)
        def result = wechatMenuService.createMenu(menuJson)
        println "testCreateMenu result: ${result}"
        expect: result && result.errcode == 0
    }

    /**
     * 自定义菜单查询
     */
    void testGetMenu() {
        def result = wechatMenuService.getMenu()
        println "testGetMenu result: ${result}"
        expect: result
    }

    /**
     * 自定义菜单删除
     */
    void testDeleteMenu() {
        def result = wechatMenuService.deleteMenu()
        println "testDeleteMenu result: ${result}"
        expect: result && result.errcode == 0
    }

    /**
     * 个性化菜单创建
     */
    void testCreateConditionalMenu() {
        def menuJson = JSON.parse(conditionalMenuStr)
        def result = wechatMenuService.createConditionalMenu(menuJson)
        println "testCreateConditionalMenu result: ${result}"
        expect: result
    }

    /**
     * 个性化菜单删除
     */
    void testDeleteConditionalMenu() {
        def result = wechatMenuService.deleteConditionalMenu("436498156")
        println "testDeleteConditionalMenu result: ${result}"
        expect: result && result.errcode == 0
    }

    /**
     * 个性化菜单匹配结果测试
     */
    void testTrymatchMenu() {
        def result = wechatMenuService.trymatchMenu("")
        println "testTrymatchMenu result: ${result}"
        expect: result
    }

    /**
     * 获取自定义菜单配置
     */
    void testGetCurrentMenuInfo() {
        def result = wechatMenuService.getCurrentMenuInfo()
        println "testGetCurrentMenuInfo result: ${result}"
        expect: result
    }
}
