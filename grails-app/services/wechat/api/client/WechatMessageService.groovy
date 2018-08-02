package wechat.api.client

import grails.converters.JSON
import grails.transaction.Transactional

/**
 * 消息管理
 * 目前只实现了模板消息相关接口
 */
@Transactional
class WechatMessageService extends WechatBaseService{

    /**
     * todo 测试
     * 模板消息
     * 设置所属行业
     * @param customerJson
     * @return
     */
    def setIndustry(industryJson) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.industrySetUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, industryJson, String.class))
        result
    }

    /**
     * todo 测试
     * 模板消息
     * 获取设置的行业信息
     * @return
     */
    def getIndustry() {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.industryGetUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
        result
    }

    /**
     * todo 测试
     * 模板消息
     * 获得模板ID
     * @param templateId
     * @return
     */
    def getTemplateIds(templateId) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.templateIdsGetUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (['template_id_short': templateId] as JSON), String.class))
        result
    }
    /**
     * 模板消息
     * 获取已添加至帐号下模板列表
     * @return
     */
    def getPrivateTemplates() {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.privateTemplatesGetUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
        result
    }

    /**
     * 模板消息
     * 删除已添加至账号的模板
     * @param templateId
     * @return
     */
    def deletePrivateTemplate(templateId) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.privateTemplateDeleteUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (['template_id': templateId] as JSON), String.class))
        result
    }

    /**
     * todo 测试
     * 模板消息
     * 发送模板消息
     * @param msgJson
     * @return
     */
    def sendTemplateMsg(msgJson) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.templateMsgSendUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, msgJson, String.class))
        result
    }
}
