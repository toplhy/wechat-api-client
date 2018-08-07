package wechat.api.client

import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(WechatQrCodeService)
class WechatQrCodeServiceSpec extends Specification {

    WechatQrCodeService wechatQrCodeService

    def setup() {
        wechatQrCodeService = mockService(WechatQrCodeService)
    }

    def cleanup(){
    }

    /**
     * 创建临时二维码
     */
    void testCreateQrCode() {
        def result = wechatQrCodeService.createQrCode("INT", 456, 7200)
        println "testCreateQrCode result: ${result}"
        expect: result
    }

    /**
     * 创建永久二维码
     */
    void testCreateLimitQrCode() {
        def result = wechatQrCodeService.createLimitQrCode("STR", "string")
        println "testCreateLimitQrCode result: ${result}"
        expect: result
    }

    /**
     * 通过ticket换取二维码
     */
    void testGetQrCode() {
        def result = wechatQrCodeService.getQrCode("gQE08DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyaGdTU2c2RmpkUWwxMDAwMHcwN2wAAgTZOmlbAwQAAAAA")
        println "testGetQrCode result: ${result}"
        expect: result
    }
}
