package wechat.api.client

import grails.converters.JSON
import grails.transaction.Transactional

/**
 * 用户管理
 */
@Transactional
class WechatUserService extends WechatBaseService{

    /**
     * todo 测试
     * 创建标签
     * @param tagName
     * @return
     */
    def createTag(tagName) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.createTagUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (["tag": ["name": tagName]] as JSON), String.class))
        result
    }

    /**
     * todo 测试
     * 编辑标签
     * @param tagId
     * @param tagName
     * @return
     */
    def updateTag(tagId, tagName) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.updateTagUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (["tag": ["id": tagId, "name": tagName]] as JSON), String.class))
        result
    }

    /**
     * todo 测试
     * 删除标签
     * @param tagId
     * @return
     */
    def deleteTag(tagId) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.deleteTagUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (["tag": ["id": tagId]] as JSON), String.class))
        result
    }

    /**
     * todo 测试
     * 获取公众号已创建的标签
     * @return
     */
    def getTags() {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getTagsUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
        result
    }

    /**
     * todo 测试
     * 获取标签下粉丝列表
     * @param tagId
     * @param nextOpenId 第一个拉取的OPENID，不填默认从头开始
     * @return
     */
    def getTagUsers(tagId, nextOpenId = "") {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getTagUsersUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (["tagid": tagId, "next_openid": nextOpenId] as JSON), String.class))
        result
    }

    /**
     * todo 测试
     * 批量为用户打标签
     * @param tagId
     * @param openIdList 每次传入的openid列表个数不能超过50个
     * @return
     */
    def batchTagUser(tagId, openIdList) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.batchTagUsersUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (["tagid": tagId, "openid_list": openIdList] as JSON), String.class))
        result
    }

    /**
     * todo 测试
     * 批量为用户取消标签
     * @param tagId
     * @param openIdList 每次传入的openid列表个数不能超过50个
     * @return
     */
    def batchUnTagUser(tagId, openIdList) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.batchUnTagUsersUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (["tagid": tagId, "openid_list": openIdList] as JSON), String.class))
        result
    }

    /**
     * todo 测试
     * 获取用户身上的标签列表
     * @param openId
     * @return
     */
    def getUserTags(openId) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUserTagsUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (["openid": openId] as JSON), String.class))
        result
    }

    /**
     * todo 测试
     * 设置用户备注名
     * @param openId
     * @param remark
     * @return
     */
    def setUserRemark(openId, remark) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.updateUserRemarkUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (["openid": openId, "remark": remark] as JSON), String.class))
        result
    }

    /**
     * todo 测试
     * 获取用户基本信息
     * @param openId
     * @param lang
     * @return
     */
    def getUserInfo(openId, lang = 'zh_CN') {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUserInfoUrl?.toString()?.replace("+++", atoken?.toString())?.replace(">>>", openId?.toString())?.replace("---", lang?.toString())
        def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
        result
    }

    /**
     * todo 测试
     * 批量获取用户基本信息
     * @param userList
     * @return
     */
    def batchGetUserInfo(userList) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.batchGetUserInfoUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (["user_list": userList] as JSON), String.class))
        result
    }

    /**
     * todo 测试
     * 获取用户列表
     * @param nextOpenId
     * @return
     */
    def getUserList(nextOpenId = "") {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUserListUrl?.toString()?.replace("+++", atoken?.toString())?.replace(">>>", nextOpenId?.toString())
        def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
        result
    }

    /**
     * todo 测试
     * 拉黑用户
     * @param openIdList 拉入黑名单的用户的openid，一次拉黑最多允许20个
     * @return
     */
    def batchBlackUser(openIdList) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.batchBalckUsersUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (["openid_list": openIdList] as JSON), String.class))
        result
    }

    /**
     * todo 测试
     * 取消拉黑用户
     * @param openIdList 拉入黑名单的用户的openid，一次拉黑最多允许20个
     * @return
     */
    def batchUnBlackUser(openIdList) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.batchUnBalckUsersUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (["openid_list": openIdList] as JSON), String.class))
        result
    }

    /**
     * todo 测试
     * 获取公众号的黑名单列表
     * @param nextOpenId 为空时，默认从开头拉取
     * @return
     */
    def getBlackUserList(nextOpenId = "") {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getBlackUserListUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (["begin_openid": beginOpenId] as JSON), String.class))
        result
    }
}
