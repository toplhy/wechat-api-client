package wechat.api.client

import grails.converters.JSON
import grails.transaction.Transactional
import grails.util.Environment
import grails.util.Holders
import org.apache.commons.lang.StringUtils
import org.codehaus.groovy.grails.commons.GrailsApplication
import org.springframework.web.client.RestTemplate
import wechat.api.client.exception.WeChatException

@Transactional
class WechatBaseService {

    GrailsApplication application
    RestTemplate restTemplate

    def wechat_config
    def access_token
    def token_expire_time

    def getApplication() {
        if(!application){
            application = Holders.grailsApplication
        }
        application
    }

    def getRestTemplate() {
        if(!restTemplate) {
            restTemplate = new RestTemplate()
        }
        restTemplate
    }

    /**
     * 获取config
     * @return
     */
    def getWechatConfig() {
        if(!wechat_config) {
            def grailsConfig = getApplication().config.wechat.api.client
            GroovyClassLoader classLoader = new GroovyClassLoader(WechatBaseService.class.getClassLoader())
            ConfigSlurper slurper = new ConfigSlurper(Environment.getCurrent().getName())
            ConfigObject defaultConfig
            try{
                defaultConfig = slurper.parse(classLoader.loadClass("WechatDefaultConfig"))
            } catch (ClassNotFoundException e) {
                throw new WeChatException(e)
            }
            wechat_config = mergeConfig(grailsConfig, (ConfigObject)defaultConfig.getProperty('wechat'))
            validatorConfig(wechat_config)
        }
        wechat_config
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
        config
    }

    /**
     * 对获得的配置校验(appId\appSecret)
     * @param config
     */
    def validatorConfig(config) {
        if(config == null) {
            throw new WeChatException("config is null.")
        }
        if(StringUtils.isBlank(config?.appId)){
            throw new WeChatException("appId is required, please confirm your config.")
        }
        if(StringUtils.isBlank(config?.appSecret)){
            throw new WeChatException("appSecret is required, please confirm your config.")
        }
    }

    /**
     * 获取access_token
     * @return
     */
    def getAccessToken() {
        if((token_expire_time?:0) < System.currentTimeMillis()) {
            def config = this.getWechatConfig()
            def url = config?.getAccessTokenUrl?.toString()?.replace("###", config?.appId?.toString())?.replace("***", config?.appSecret?.toString())
            def json =  JSON.parse(getRestTemplate().getForObject(url, String.class))
            if(json.access_token){
                token_expire_time =  System.currentTimeMillis()+7000*1000
                access_token =  json.access_token
            } else {
                throw new WeChatException("get access_token failed: ${json}")
            }
        }
        access_token
    }

    /**
     * 获取微信服务器IP地址
     * @return
     */
    def getWechatServerIps() {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getWechatServerIpsUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
        result
    }

    /**
     * TODO 测试
     * 长链接转短链接
     * @param longUrl
     * @return
     */
    def getShortUrl(String longUrl) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getLong2shortUrl?.toString()?.replace("+++", atoken?.toString())
        def map = [:]
        map.action = 'long2short'
        map.long_url = longUrl
        def result = JSON.parse(this.getRestTemplate().postForObject(url, map as JSON, String.class))
        result
    }
}
