package wechat.api.client

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(WechatUserService)
class WechatUserServiceSpec extends Specification {

    WechatUserService wechatUserService

    def setup() {
        wechatUserService = mockService(WechatUserService)
    }

    def cleanup(){
    }

    /**
     * 创建标签
     */
    void testCreateTag() {
        def result = wechatUserService.createTag("friends")
        println "testCreateTag result: ${result}"
        expect: result
    }

    /**
     * 编辑标签
     */
    void testUpdateTag() {
        def result = wechatUserService.updateTag(100,"friend")
        println "testUpdateTag result: ${result}"
        expect: result && result.errcode == 0
    }

    /**
     * 删除标签
     */
    void testDeleteTag() {
        def result = wechatUserService.deleteTag(100)
        println "testDeleteTag result: ${result}"
        expect: result && result.errcode == 0
    }

    /**
     * 获取公众号已创建的标签
     */
    void testGetTags() {
        def result = wechatUserService.getTags()
        println "testGetTags result: ${result}"
        expect: result
    }

    /**
     * 获取标签下粉丝列表
     */
    void testGetTagUsers() {
        def result = wechatUserService.getTagUsers(101)
        println "testGetTagUsers result: ${result}"
        expect: result
    }

    /**
     * 批量为用户打标签
     */
    void testBatchTagUser() {
        def list = ["oKVN01dq09qGVIQVjthHox_3JCf8"]
        def result = wechatUserService.batchTagUser(101, list)
        println "testBatchTagUser result: ${result}"
        expect: result && result.errcode == 0
    }

    /**
     * 批量为用户取消标签
     */
    void testBatchUnTagUser() {
        def list = ["oKVN01dq09qGVIQVjthHox_3JCf8"]
        def result = wechatUserService.batchUnTagUser(101, list)
        println "testBatchUnTagUser result: ${result}"
        expect: result && result.errcode == 0
    }

    /**
     * 获取用户身上的标签列表
     */
    void testGetUserTags() {
        def openId = "oKVN01dq09qGVIQVjthHox_3JCf8"
        def result = wechatUserService.getUserTags(openId)
        println "testGetUserTags result: ${result}"
        expect: result
    }

    /**
     * 设置用户备注名
     */
    void testSetUserRemark() {
        def openId = "oKVN01dq09qGVIQVjthHox_3JCf8"
        def result = wechatUserService.setUserRemark(openId, "hello")
        println "testSetUserRemark result: ${result}"
        expect: result
    }

    /**
     * 获取用户基本信息
     */
    void testGetUserInfo() {
        def openId = "oKVN01dq09qGVIQVjthHox_3JCf8"
        def result = wechatUserService.getUserInfo(openId)
        println "testGetUserInfo result: ${result}"
        expect: result
    }

    /**
     * 批量获取用户基本信息
     */
    void testBatchGetUserInfo() {
        def list = ["oKVN01dq09qGVIQVjthHox_3JCf8"]
        def result = wechatUserService.batchGetUserInfo(list)
        println "testBatchGetUserInfo result: ${result}"
        expect: result
    }

    /**
     * 获取用户列表
     */
    void testGetUserList() {
        def result = wechatUserService.getUserList()
        println "testGetUserList result: ${result}"
        expect: result
    }

    /**
     * 拉黑用户
     */
    void testBatchBlackUser() {
        def list = ["oKVN01dq09qGVIQVjthHox_3JCf8"]
        def result = wechatUserService.batchBlackUser(list)
        println "testBatchBlackUser result: ${result}"
        expect: result && result.errcode == 0
    }

    /**
     * 取消拉黑用户
     */
    void testBatchUnBlackUser() {
        def list = ["oKVN01dq09qGVIQVjthHox_3JCf8"]
        def result = wechatUserService.batchUnBlackUser(list)
        println "testBatchUnBlackUser result: ${result}"
        expect: result && result.errcode == 0
    }

    /**
     * 获取公众号的黑名单列表
     */
    void testGetBlackUserList() {
        def result = wechatUserService.getBlackUserList()
        println "testGetBlackUserList result: ${result}"
        expect: result
    }
}
