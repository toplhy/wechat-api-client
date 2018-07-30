package wechat.api.client.weixin

import wechat.api.client.WechatBaseService
import wechat.api.client.enums.EventType
import wechat.api.client.enums.MsgType
import wechat.api.client.interfaces.EventInterface
import wechat.api.client.interfaces.MessageInterface
import wechat.api.client.proxy.FacadeProxy
import wechat.api.client.utils.MessageUtils

class WeixinController {

    WechatBaseService wechatBaseService
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
        def config = wechatBaseService.getWechatConfig()
        // 验证服务有效性时为GET请求
        if(request.method == "GET"){
            validateServer(config, params)
        }
        // 接收消息时为POST请求
        if(request.method == "POST"){
            processMessage(request, config, params)
        }
    }

    /**
     * 验证服务有效性
     * @return
     */
    def validateServer(config, params) {
        String token = config?.token
        String signature = params?.signature
        String timestamp = params?.timestamp
        String nonce = params?.nonce
        String echostr = params?.echostr
        String str = [token, timestamp, nonce].sort().join('').encodeAsSHA1()
        if(str == signature) {
            render echostr
        } else {
            render ""
        }
    }

    /**
     * 接收微信消息
     * @return
     */
    def processMessage(request, config, params) {
        def xmlStr = request.getInputStream().getText("UTF-8")
        if(config?.encodingType && config?.encodingType?.equals("MIWEN")){
            xmlStr = MessageUtils.decode(xmlStr, config, params?.msg_signature, params?.timestamp, params?.nonce)
        }
        def xmlslurper = new XmlSlurper()
        def xml = xmlslurper.parseText(xmlStr.toString())
        def map = [:], msg
        map.ToUserName = xml.ToUserName.text()
        map.FromUserName = xml.FromUserName.text()
        map.CreateTime = xml.CreateTime.text()
        map.MsgType = xml.MsgType.text()
        def msg_type = xml.MsgType.text()
        if(msg_type == MsgType.EVENT) {
            def event_type = xml.Event.text()
            map.event = event_type
            if(event_type == EventType.SUBSCRIBE.value){
                if(xml?.Ticket?.text()) {
                    map.EventKey = xml?.EventKey?.text()
                    map.Ticket = xml?.Ticket?.text()
                }
            } else if(event_type == EventType.UNSUBSCRIBE.value) {

            } else if(event_type == EventType.SCAN.value) {
                map.EventKey = xml?.EventKey?.text()
                map.Ticket = xml?.Ticket?.text()
            } else if(event_type == EventType.LOCATION.value) {
                map.Latitude = xml.Latitude.text()
                map.Longitude = xml.Longitude.text()
                map.Precision = xml.Precision.text()
            } else if(event_type == EventType.CLICK.value){
                map.EventKey = xml?.EventKey?.text()
            } else if(event_type == EventType.VIEW.value){
                map.EventKey = xml?.EventKey?.text()
            } else if(event_type == EventType.SCANCODEPUSH.value){
                map.EventKey = xml?.EventKey?.text()
                map.ScanCodeInfo = xml.ScanCodeInfo.text()
                map.ScanType = xml.ScanType.text()
                map.ScanResult = xml.ScanResult.text()
            } else if(event_type == EventType.SCANCODEWAITMSG.value){
                map.EventKey = xml?.EventKey?.text()
                map.ScanCodeInfo = xml.ScanCodeInfo.text()
                map.ScanType = xml.ScanType.text()
                map.ScanResult = xml.ScanResult.text()
            } else if(event_type == EventType.PICSYSPHOTO.value || event_type == EventType.PICPHOTOORALBUM.value || event_type == EventType.PICWEIXIN.value){
                map.EventKey = xml?.EventKey?.text()
                map.SendPicsInfo = xml.SendPicsInfo.text()
                map.Count = xml.Count.text()
                map.PicList = xml.PicList.text()
                map.PicMd5Sum = map.PicMd5Sum.text()
            } else if(event_type == EventType.LOCATIONSELECT.value){
                map.EventKey = xml?.EventKey?.text()
                map.SendLocationInfo = xml.SendLocationInfo.text()
                map.Location_X = xml.Location_X.text()
                map.Location_X = xml.Location_X.text()
                map.Scale = xml.Scale.text()
                map.Label = xml.Label.text()
                map.Poiname = xml.Poiname.text()
            } else if(event_type == EventType.TEMPLATESENDJOBFINISH.value){
                map.MsgID = xml.MsgID.text()
                map.Status = xml.Status.text()
            } else if(event_type == EventType.MASSSENDJOBFINISH.value){
                map.MsgID = xml.MsgID.text()
                map.Status = xml.Status.text()
                map.TotalCount = xml.TotalCount.text()
                map.FilterCount = xml.FilterCount.text()
                map.SentCount = xml.SentCount.text()
                map.ErrorCount = xml.ErrorCount.text()
                map.ResultList = xml.ResultList.text()
                map.ArticleIdx = xml.ArticleIdx.text()
                map.UserDeclareState = xml.UserDeclareState.text()
                map.AuditState = xml.AuditState.text()
                map.OriginalArticleUrl = xml.OriginalArticleUrl.text()
                map.OriginalArticleType = xml.OriginalArticleType.text()
                map.CanReprint = xml.CanReprint.text()
                map.NeedReplaceContent = xml.NeedReplaceContent.text()
                map.NeedShowReprintSource = xml.NeedShowReprintSource.text()
                map.CheckState = xml.CheckState.text()
                map.CheckState = xml.CheckState.text()
            } else {

            }
            if(getEventInterface().beforeHandleEvent(map)){
                msg = getEventInterface().handleEvent(map)
            }
            if(msg) {
                getEventInterface().afterHandleEvent(map)
                def msgResult = MessageUtils.mapToXmlString(msg)
                if(config?.encodingType && config?.encodingType?.equals("MIWEN")) {
                    //消息加密
                    msgResult = MessageUtils.encode(msgResult, config, params?.timestamp, params?.nonce)
                }
                render msgResult
            } else {
                render "success"
            }
        } else {
            map.MsgId = xml.MsgId.text()
            if (msg_type == MsgType.TEXT.value) {
                map.Content = xml.Content.text()
            } else if (msg_type == MsgType.IMAGE.value) {
                map.PicUrl = xml.PicUrl.text()
                map.MediaId = xml.MediaId.text()
            } else if(msg_type == MsgType.VOICE.value) {
                map.MediaId = xml.MediaId.text()
                map.Format = xml.Format.text()
                map.Recognition = xml.Recognition.text()
            } else if(msg_type == MsgType.VIDEO.value || msg_type == MsgType.SHORTVIDEO.value) {
                map.MediaId = xml.MediaId.text()
                map.ThumbMediaId = xml.ThumbMediaId.text()
            } else if (msg_type == MsgType.LOCATION.value) {
                map.Scale = xml.Scale.text()
                map.Label = xml.Label.text()
                map.Location_Y = xml.Location_Y.text()
                map.Location_X = xml.Location_X.text()
            } else if (msg_type == MsgType.LINK.value) {
                map.Title = xml.Title.text()
                map.Description = xml.Description.text()
                map.Url = xml.Url.text()
            } else {

            }
            if(getMessageInterface().beforeHandleMessage(map)){
                msg = getMessageInterface().handleMessage(map)
            }
            if(msg) {
                getMessageInterface().afterHandleMessage(map)
                def msgResult = MessageUtils.mapToXmlString(msg)
                if(config?.encodingType && config?.encodingType?.equals("MIWEN")) {
                    //消息加密
                    msgResult = MessageUtils.encode(msgResult, config, params?.timestamp, params?.nonce)
                }
                render msgResult
            } else {
                render "success"
            }
        }
    }

}
