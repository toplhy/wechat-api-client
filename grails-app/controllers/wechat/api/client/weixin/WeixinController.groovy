package wechat.api.client.weixin

import grails.converters.JSON
import wechat.api.client.WechatService
import wechat.api.client.enums.EventType
import wechat.api.client.enums.MsgType
import wechat.api.client.interfaces.EventInterface
import wechat.api.client.interfaces.MessageInterface
import wechat.api.client.proxy.FacadeProxy

class WeixinController {

    WechatService wechatService
    MessageInterface messageInterface
    EventInterface eventInterface

    def getMessageInterface() {
        if(!messageInterface) {
            messageInterface = FacadeProxy.newMapperProxy(MessageInterface.class, "wechat.api.client.impl.MessageInterfaceImpl")
        }
        messageInterface
    }

    def getEventInterface() {
        if(!eventInterface) {
            eventInterface =  FacadeProxy.newMapperProxy(MessageInterface.class, "wechat.api.client.impl.EventInterfaceImpl")
        }
        eventInterface
    }

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
            if(msg_type == MsgType.EVENT){
                def event_type = xml.Event.text()
                if(event_type == EventType.SUBSCRIBE){

                } else if(event_type == EventType.UNSUBSCRIBE) {

                } else if(event_type == EventType.SCAN) {

                } else if(event_type == EventType.LOCATION) {

                } else if(event_type == EventType.CLICK){

                } else if(event_type == EventType.VIEW){

                } else if(event_type == EventType.SCANCODEPUSH){

                } else if(event_type == EventType.SCANCODEWAITMSG){

                } else if(event_type == EventType.PICSYSPHOTO){

                } else if(event_type == EventType.PICPHOTOORALBUM){

                } else if(event_type == EventType.PICWEIXIN){

                } else if(event_type == EventType.LOCATIONSELECT){

                } else if(event_type == EventType.TEMPLATESENDJOBFINISH){

                } else if(event_type == EventType.MASSSENDJOBFINISH){

                }
            }else {
                if (msg_type == MsgType.TEXT) {
                    map.Content = xml.Content.text()
                    messageInterface.beforeHandleText(map)
                    messageInterface.handleText(map)
                    messageInterface.afterHandleText(map)
                } else if (msg_type == MsgType.IMAGE) {
                    map.PicUrl = xml.PicUrl.text()
                    map.MediaId = xml.MediaId.text()
                } else if(msg_type == MsgType.VOICE) {
                    map.MediaId = xml.MediaId.text()
                    map.Format = xml.Format.text()
                    map.Recognition = xml.Recognition.text()
                } else if(msg_type == MsgType.VIDEO || msg_type == MsgType.SHORTVIDEO) {
                    map.MediaId = xml.MediaId.text()
                    map.ThumbMediaId = xml.ThumbMediaId.text()
                } else if (msg_type == MsgType.LOCATION) {
                    map.Scale = xml.Scale.text()
                    map.Label = xml.Label.text()
                    map.Location_Y = xml.Location_Y.text()
                    map.Location_X = xml.Location_X.text()
                } else if (msg_type == MsgType.LINK) {
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
