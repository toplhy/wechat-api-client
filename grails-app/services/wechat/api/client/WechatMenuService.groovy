package wechat.api.client

import grails.converters.JSON
import grails.transaction.Transactional

/**
 * 自定义菜单
 */
@Transactional
class WechatMenuService extends WechatBaseService{

    /**
     * 自定义菜单创建
     * @param menuJson
     * @return
     */
    def createMenu(menuJson) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.createMenuUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, menuJson, String.class))
        result
    }

    /**
     * 自定义菜单查询
     * @return
     */
    def getMenu() {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getMenuUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
        result
    }

    /**
     * 自定义菜单删除
     * @return
     */
    def deleteMenu() {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.deleteMenuUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
        result
    }

    /**
     * todo 测试
     * 个性化菜单创建
     * @param menuJson
     * @return
     */
    def createConditionalMenu(menuJson) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.createConditionalMenuUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, menuJson, String.class))
        result
    }

    /**
     * todo 测试
     * 个性化菜单删除
     * @param menuIdJson 菜单id json
     * @return
     */
    def deleteConditionalMenu(menuIdJson) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.deleteConditionalMenueUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, menuIdJson, String.class))
        result
    }

    /**
     * todo 测试
     * 个性化菜单匹配结果测试
     * @param userIdJson user_id可以是openId，也可以是微信号 json
     * @return
     */
    def trymatchMenu(userIdJson) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.tryMatchMenuUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, userIdJson, String.class))
        result
    }

    /**
     * 获取自定义菜单配置
     * @return
     */
    def getCurrentMenuInfo() {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getCurrentMenuInfoUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
        result
    }
}