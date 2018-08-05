package wechat.api.client

import grails.converters.JSON
import grails.transaction.Transactional

/**
 * 数据统计
 */
@Transactional
class WechatDatacubeService extends WechatBaseService{

    /**
     * TODO 测试
     * 获取用户增减数据(最大时间跨度7天)
     * @param beginDate
     * @param endDate
     * @return
     */
    def getUserSummary(Date beginDate, Date endDate) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUserSummaryUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": beginDate?.format('yyyy-MM-dd'), "end_date": endDate?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取累计用户数据(最大时间跨度7天)
     * @param beginDate
     * @param endDate
     * @return
     */
    def getUserCumulate(Date beginDate, Date endDate) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUserCumulateUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": beginDate?.format('yyyy-MM-dd'), "end_date": endDate?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取图文群发每日数据(最大时间跨度1天)
     * @param date
     * @return
     */
    def getArticleSummary(Date date) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getArticleSummaryUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": date?.format('yyyy-MM-dd'), "end_date": date?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取图文群发总数据(最大时间跨度1天)
     * @param date
     * @return
     */
    def getArticleTotal(Date date) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getArticleTotalUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": date?.format('yyyy-MM-dd'), "end_date": date?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取图文统计数据(最大时间跨度3天)
     * @param beginDate
     * @param endDate
     * @return
     */
    def getUserRead(Date beginDate, Date endDate) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUserReadUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": beginDate?.format('yyyy-MM-dd'), "end_date": endDate?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取图文统计分时数据(最大时间跨度1天)
     * @param date
     * @return
     */
    def getUserReadHour(Date date) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUserReadHourUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": date?.format('yyyy-MM-dd'), "end_date": date?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取图文分享转发数据(最大时间跨度7天)
     * @param beginDate
     * @param endDate
     * @return
     */
    def getUserShare(Date beginDate, Date endDate) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUserShareUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": beginDate?.format('yyyy-MM-dd'), "end_date": endDate?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取图文分享转发分时数据(最大时间跨度1天)
     * @param date
     * @return
     */
    def getUserShareHour(Date date) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUserShareHourUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": date?.format('yyyy-MM-dd'), "end_date": date?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取消息发送概况数据(最大时间跨度7天)
     * @param beginDate
     * @param endDate
     * @return
     */
    def getUpstreamMsg(Date beginDate, Date endDate) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUpstreamMsgUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": beginDate?.format('yyyy-MM-dd'), "end_date": endDate?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取消息分送分时数据(最大时间跨度1天)
     * @param date
     * @return
     */
    def getUpstreamMsgHour(Date date) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUpstreamMsgHourUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": date?.format('yyyy-MM-dd'), "end_date": date?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取消息发送周数据(最大时间跨度30天)
     * @param beginDate
     * @param endDate
     * @return
     */
    def getUpstreamMsgWeek(Date beginDate, Date endDate) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUpstreamMsgWeekUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": beginDate?.format('yyyy-MM-dd'), "end_date": endDate?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取消息发送月数据(最大时间跨度30天)
     * @param beginDate
     * @param endDate
     * @return
     */
    def getUpstreamMsgMonth(Date beginDate, Date endDate) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUpstreamMsgMonthUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": beginDate?.format('yyyy-MM-dd'), "end_date": endDate?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取消息发送分布数据(最大时间跨度15天)
     * @param beginDate
     * @param endDate
     * @return
     */
    def getUpstreamMsgDist(Date beginDate, Date endDate) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUpstreamMsgDistUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": beginDate?.format('yyyy-MM-dd'), "end_date": endDate?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取消息发送分布周数据(最大时间跨度30天)
     * @param beginDate
     * @param endDate
     * @return
     */
    def getUpstreamMsgDistWeek(Date beginDate, Date endDate) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUpstreamMsgDistWeekUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": beginDate?.format('yyyy-MM-dd'), "end_date": endDate?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取消息发送分布月数据(最大时间跨度30天)
     * @param beginDate
     * @param endDate
     * @return
     */
    def getUpstreamMsgDistMonthUrl(Date beginDate, Date endDate) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getUpstreamMsgUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": beginDate?.format('yyyy-MM-dd'), "end_date": endDate?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取接口分析数据(最大时间跨度30天)
     * @param beginDate
     * @param endDate
     * @return
     */
    def getInterfaceSummary(Date beginDate, Date endDate) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getInterfaceSummaryUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": beginDate?.format('yyyy-MM-dd'), "end_date": endDate?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }

    /**
     * TODO 测试
     * 获取接口分析分时数据(最大时间跨度1天)
     * @param date
     * @return
     */
    def getInterfaceSummaryHour(Date date) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getInterfaceSummaryHourUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["begin_date": date?.format('yyyy-MM-dd'), "end_date": date?.format("yyyy-MM-dd")]
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data as JSON, String.class))
        result
    }
}
