package wechat.api.client

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * WechatMaterialService class test
 */
@TestFor(WechatMaterialService)
class WechatMaterialServiceSpec extends Specification{

    WechatMaterialService wechatMaterialService
    File videofile, imageFile

    def setup() {
        wechatMaterialService = mockService(WechatMaterialService)
        videofile = new File("D:\\CloudMusic\\MV\\123.mp4")
        imageFile = new File("D:\\CloudMusic\\MV\\1099.jpg")
    }

    def cleanup() {
    }

    /**
     * 生成post form 请求
     */
    void testGeneRequest() {
        def result = wechatMaterialService.geneRequest(imageFile)
        println "testGeneRequest result: ${result}"
        expect: result
    }

    /**
     * 新增临时素材
     */
    void testUploadMedia() {
        def result = wechatMaterialService.uploadMedia(imageFile, "image")
        println "testUploadMedia result: ${result}"
        expect: result
    }

    /**
     * 获取临时素材
     */
    void testGetMedia1() {
        def mediaId = "N8B5QtIVV3QxV4hOIz1mOD4XS98jAWeh9tcwYZB3DQr8JDDs-QTQI-UP_BeNMc47" //video
        def result = wechatMaterialService.getMedia(mediaId, true)
        println "testGetMedia result（video）: ${result}"
        expect: result
    }

    /**
     * 获取临时素材
     */
    void testGetMedia2() {
        def mediaId = "ThxJhH0cZmlOwWJSkrIiiXK-3r1VkogKG3bH5CEsvAFlN-Yqfdu1_QWL45uR4uPI" //image
        def result = wechatMaterialService.getMedia(mediaId)
        println "testGetMedia result（image）: ${result}"
        expect: result
    }

    /**
     * 新增其他类型永久素材
     * 视频素材未完成
     */
    void testAddMaterial() {
        def result = wechatMaterialService.addMaterial(imageFile, "image")
        println "testAddMaterial result: ${result}"
        expect: result
    }

    /**
     * 获取永久素材
     */
    void testGetMaterial() {

    }

    /**
     * 获取素材列表
     */
    void testListMaterial() {
        def result = wechatMaterialService.listMaterial("news")
        println "testListMaterial result: ${result}"
        expect: result
    }
}
