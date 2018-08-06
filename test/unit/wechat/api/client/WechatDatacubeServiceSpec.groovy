package wechat.api.client

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * WechatDatacubeService test class
 */
@TestFor(WechatDatacubeService)
class WechatDatacubeServiceSpec extends Specification{

    WechatDatacubeService wechatDatacubeService

    def setup() {
        wechatDatacubeService = mockService(WechatDatacubeService)
    }

    def cleanup() {
    }

    /**
     *  获取用户增减数据(最大时间跨度7天)
     */
    void testGetUserSummary() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 6, 2)
        def beginDate = calendar.getTime()
        calendar.set(2018, 6, 8)
        def endDate = calendar.getTime()
        def result = wechatDatacubeService.getUserSummary(beginDate, endDate)
        println "testGetUserSummary result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取累计用户数据(最大时间跨度7天)
     */
    void testGetUserCumulate() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 6, 2)
        def beginDate = calendar.getTime()
        calendar.set(2018, 6, 8)
        def endDate = calendar.getTime()
        def result = wechatDatacubeService.getUserCumulate(beginDate, endDate)
        println "testGetUserCumulate result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取图文群发每日数据(最大时间跨度1天)
     */
    void testGetArticleSummary() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 6, 5)
        def date = calendar.getTime()
        def result = wechatDatacubeService.getArticleSummary(date)
        println "testGetArticleSummary result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取图文群发总数据(最大时间跨度1天)
     */
    void testGetArticleTotal() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 6, 5)
        def date = calendar.getTime()
        def result = wechatDatacubeService.getArticleTotal(date)
        println "testGetArticleTotal result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取图文统计数据(最大时间跨度3天)
     */
    void testGetUserRead() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 6, 2)
        def beginDate = calendar.getTime()
        calendar.set(2018, 6, 4)
        def endDate = calendar.getTime()
        def result = wechatDatacubeService.getUserRead(beginDate, endDate)
        println "testGetUserRead result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取图文统计分时数据(最大时间跨度1天)
     */
    void testGetUserReadHour() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 6, 5)
        def date = calendar.getTime()
        def result = wechatDatacubeService.getUserReadHour(date)
        println "testGetUserReadHour result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取图文分享转发数据(最大时间跨度7天)
     */
    void testGetUserShare() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 6, 2)
        def beginDate = calendar.getTime()
        calendar.set(2018, 6, 8)
        def endDate = calendar.getTime()
        def result = wechatDatacubeService.getUserShare(beginDate, endDate)
        println "testGetUserShare result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取图文分享转发分时数据(最大时间跨度1天)
     */
    void testGetUserShareHour() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 6, 5)
        def date = calendar.getTime()
        def result = wechatDatacubeService.getUserShareHour(date)
        println "testGetUserShareHour result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取消息发送概况数据(最大时间跨度7天)
     */
    void testGetUpstreamMsg() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 6, 2)
        def beginDate = calendar.getTime()
        calendar.set(2018, 6, 8)
        def endDate = calendar.getTime()
        def result = wechatDatacubeService.getUpstreamMsg(beginDate, endDate)
        println "testGetUpstreamMsg result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取消息分送分时数据(最大时间跨度1天)
     */
    void testGetUpstreamMsgHour() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 6, 5)
        def date = calendar.getTime()
        def result = wechatDatacubeService.getUpstreamMsgHour(date)
        println "testGetUpstreamMsgHour result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取消息发送周数据(最大时间跨度30天)
     */
    void testGetUpstreamMsgWeek() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 5, 8)
        def beginDate = calendar.getTime()
        calendar.set(2018, 6, 7)
        def endDate = calendar.getTime()
        def result = wechatDatacubeService.getUpstreamMsgWeek(beginDate, endDate)
        println "testGetUpstreamMsgWeek result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取消息发送月数据(最大时间跨度30天)
     */
    void testGetUpstreamMsgMonth() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 5, 8)
        def beginDate = calendar.getTime()
        calendar.set(2018, 6, 7)
        def endDate = calendar.getTime()
        def result = wechatDatacubeService.getUpstreamMsgMonth(beginDate, endDate)
        println "testGetUpstreamMsgMonth result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取消息发送分布数据(最大时间跨度15天)
     */
    void testGetUpstreamMsgDist() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 5, 8)
        def beginDate = calendar.getTime()
        calendar.set(2018, 5, 22)
        def endDate = calendar.getTime()
        def result = wechatDatacubeService.getUpstreamMsgDist(beginDate, endDate)
        println "testGetUpstreamMsgDist result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取消息发送分布周数据(最大时间跨度30天)
     */
    void testGetUpstreamMsgDistWeek() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 5, 8)
        def beginDate = calendar.getTime()
        calendar.set(2018, 6, 7)
        def endDate = calendar.getTime()
        def result = wechatDatacubeService.getUpstreamMsgDistWeek(beginDate, endDate)
        println "testGetUpstreamMsgDistWeek result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取消息发送分布月数据(最大时间跨度30天)
     */
    void testGetUpstreamMsgDistMonth() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 5, 8)
        def beginDate = calendar.getTime()
        calendar.set(2018, 6, 7)
        def endDate = calendar.getTime()
        def result = wechatDatacubeService.getUpstreamMsgDistMonth(beginDate, endDate)
        println "testGetUpstreamMsgDistMonth result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取接口分析数据(最大时间跨度30天)
     */
    void testGetInterfaceSummary() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 5, 8)
        def beginDate = calendar.getTime()
        calendar.set(2018, 6, 7)
        def endDate = calendar.getTime()
        def result = wechatDatacubeService.getInterfaceSummary(beginDate, endDate)
        println "testGetInterfaceSummary result: ${result}"
        expect: result && !result.errcode
    }

    /**
     *  获取接口分析分时数据(最大时间跨度1天)
     */
    void testGetInterfaceSummaryHour() {
        Calendar calendar = Calendar.getInstance()
        calendar.set(2018, 6, 5)
        def date = calendar.getTime()
        def result = wechatDatacubeService.getInterfaceSummaryHour(date)
        println "testGetInterfaceSummaryHour result: ${result}"
        expect: result && !result.errcode
    }
}
