package wechat.api.client

import grails.converters.JSON
import grails.transaction.Transactional

@Transactional
class WechatOAuth2Service extends WechatBaseService{

    /**
     * 获取网页授权链接
     * @param redirectUrl
     * @param scope
     * @param state
     * @return
     */
    def getOAuth2Url(redirectUrl, scope, state) {
        def config = this.getWechatConfig()
        def url = config?.oAuth2GetUrl?.toString()?.replace("###", config?.appId?.toString())
        redirectUrl = URLEncoder.encode(redirectUrl?.toString())
        url += "&redirect_uri=${redirectUrl}&response_type=code&scope=${scope}&state=${state}#wechat_redirect"
        url
    }

    /**
     * 通过code换取网页授权access_token
     * @param code
     * @return
     */
    def getOAuth2AccessToken(code) {
        def config = this.getWechatConfig()
        def url = config?.oAuth2AccessTokenUrl?.toString()?.replace("###", config?.appId?.toString())?.replace("***", config?.appSecret?.toString())?.replace("---", code?.toString())
        def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
        result
    }

    /**
     * 刷新access_token
     * @param refreshToken
     * @return
     */
    def refreshAccessToken(refreshToken) {
        def config = this.getWechatConfig()
        def url = config?.tokenRefreshUrl?.toString()?.replace("###", config?.appId?.toString())?.replace("---", refreshToken?.toString())
        def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
        result
    }

    /**
     * 获取用户信息
     * @param accessToken 网页授权AccessToken(不是基础支持的access_token)
     * @param openId
     * @param lang 国家地区语言
     * @return
     */
    def getUserInfo(accessToken, openId, lang = 'zh_CN') {
        def config = this.getWechatConfig()
        def url = config?.userInfoUrl?.toString()?.replace("+++", accessToken?.toString())?.replace(">>>", openId?.toString())?.replace("---", lang?.toString())
        def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
        result
    }

    /**
     * 检验授权凭证（access_token）是否有效
     * @param accessToken
     * @param openId
     * @return
     */
    def validateAccessToken(accessToken, openId) {
        def config = this.getWechatConfig()
        def url = config?.tokenValidateUrl?.toString()?.replace("+++", accessToken?.toString())?.replace(">>>", openId?.toString())
        def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
        result
    }
}
