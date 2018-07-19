package wechat.api.client.weixin

import grails.converters.JSON
import wechat.api.client.WechatService

class WeixinController {

    WechatService wechatService

    def index() {
        def config = wechatService.getWechatConfig()
        if(params?.echostr) {
            String token = config?.token
            String signature = params?.signature
            String timestamp = params?.timestamp
            String nonce = params?.nonce
            String echostr = params?.echostr
            String str = [token, timestamp, nonce].sort().join('').encodeAsSHA1()
            if(str == signature) {
                return echostr
            } else {
                return ""
            }
        } else {
            def xmlStr = request.getInputStream().getText("UTF-8")
            def xmlslurper = new XmlSlurper()
            def xml = xmlslurper.parseText(xmlStr)
            def map = [:]
            map.ToUserName = xml.ToUserName.text()
            map.FromUserName = xml.FromUserName.text()
            map.CreateTime = xml.CreateTime.text()
            map.MsgType = xml.MsgType.text()
            map.MsgId = xml.MsgId.text()
            def msg_type = xml.MsgType.text()
            if(msg_type=="event"){
                def event_type = xml.Event.text()

            }else {
                if (msg_type == 'text') {
                    map.Content = xml.Content.text()
                } else if (msg_type == 'image') {
                    map.PicUrl = xml.PicUrl.text()
                    map.MediaId = xml.MediaId.text()
                } else if(msg_type == 'voice') {
                    map.MediaId = xml.MediaId.text()
                    map.Format = xml.Format.text()
                    map.Recognition = xml.Recognition.text()
                } else if(msg_type == 'video' || msg_type == 'shortvideo') {
                    map.MediaId = xml.MediaId.text()
                    map.ThumbMediaId = xml.ThumbMediaId.text()
                } else if (msg_type == 'location') {
                    map.Scale = xml.Scale.text()
                    map.Label = xml.Label.text()
                    map.Location_Y = xml.Location_Y.text()
                    map.Location_X = xml.Location_X.text()
                } else if (msg_type == 'link') {
                    map.Title = xml.Title.text()
                    map.Description = xml.Description.text()
                    map.Url = xml.Url.text()
                }
                println map as JSON
                render "success"
            }
        }
    }

}