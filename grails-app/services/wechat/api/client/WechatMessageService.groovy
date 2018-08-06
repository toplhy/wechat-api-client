package wechat.api.client

import grails.converters.JSON
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.JSONObject

/**
 * 消息管理
 * 目前只实现了模板消息相关接口
 */
@Transactional
class WechatMessageService extends WechatBaseService{

    /**
     * 模板消息
     * 设置所属行业
     * @param
     * @return
     */
    def setIndustry(industryId1, industryId2) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.setIndustryUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, ["industry_id1": industryId1, "industry_id2": industryId2] as JSONObject, String.class))
        result
    }

    /**
     * 模板消息
     * 获取设置的行业信息
     * @return
     */
    def getIndustry() {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getIndustryUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
        result
    }

    /**
     * 模板消息
     * 获得模板ID
     * @param templateId
     * @return
     */
    def getTemplateIds(templateId) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getTemplateIdsUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (['template_id_short': templateId] as JSONObject), String.class))
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
        def url = config?.getPrivateTemplatesUrl?.toString()?.replace("+++", atoken?.toString())
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
        def url = config?.deletePrivateTemplateUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (['template_id': templateId] as JSON), String.class))
        result
    }

    /**
     * 模板消息
     * 发送模板消息
     * @param msgJson
     * @return
     */
    def sendTemplateMsg(msgJson) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.sendTemplateMsgUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, msgJson, String.class))
        result
    }
}
