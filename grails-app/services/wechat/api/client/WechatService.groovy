package wechat.api.client

import grails.transaction.Transactional
import grails.util.Environment
import grails.util.Holders
import org.apache.commons.lang.StringUtils
import org.codehaus.groovy.grails.commons.GrailsApplication
import wechat.api.client.exception.WeChatException

@Transactional
class WechatService {

    GrailsApplication application

    def getApplication() {
        if(!application){
            application = Holders.grailsApplication
        }
        application
    }

    /**
     * 获取config
     * @return
     */
    def getWechatConfig() {
        def grailsConfig = getApplication().config.wechat.api.client
        GroovyClassLoader classLoader = new GroovyClassLoader(WechatService.class.getClassLoader())
        ConfigSlurper slurper = new ConfigSlurper(Environment.getCurrent().getName())
        ConfigObject defaultConfig
        try{
            defaultConfig = slurper.parse(classLoader.loadClass("WechatDefaultConfig"))
        } catch (ClassNotFoundException e) {
            throw new WeChatException(e)
        }
        def config = mergeConfig(grailsConfig, (ConfigObject)defaultConfig.getProperty('wechat'))
        validatorConfig(config)
        return config
    }

    /**
     * 将grails项目中定义的配置和默认配置合并
     * @param grailsConfig
     * @param defaultConfig
     * @return
     */
    def mergeConfig(grailsConfig, defaultConfig) {
        ConfigObject config = new ConfigObject()
        if (defaultConfig == null) {
            if (grailsConfig != null) {
                config.putAll(grailsConfig)
            }
        }
        else {
            if (grailsConfig == null) {
                config.putAll(defaultConfig)
            } else {
                config.putAll(defaultConfig.merge(grailsConfig))
            }
        }
        return config
    }

    /**
     * 对获得的配置校验(appId\appSecret\domain)
     * @param config
     */
    def validatorConfig(config) {
        if(StringUtils.isBlank(config?.appId)){
            throw new WeChatException("appId is required, please confirm your config.")
        }
        if(StringUtils.isBlank(config?.appSecret)){
            throw new WeChatException("appSecret is required, please confirm your config.")
        }
        if(StringUtils.isBlank(config?.domain)){
            throw new WeChatException("domain is required, please confirm your config.")
        }
    }

}
