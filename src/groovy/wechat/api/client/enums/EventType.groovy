package wechat.api.client.enums

enum EventType {

    SUBSCRIBE("subscribe"), // 关注事件
    UNSUBSCRIBE("unsubscribe"), // 取消关注事件
    SCAN("SCAN"), // 扫描带参数二维码事件（已关注）
    LOCATION("LOCATION"), // 上报地理位置事件
    CLICK("CLICK"), // 点击菜单拉取消息时的事件推送
    VIEW("VIEW"), // 点击菜单跳转链接时的事件推送
    SCANCODEPUSH("scancode_push"), // 扫码推事件的事件推送
    SCANCODEWAITMSG("scancode_waitmsg"), // 扫码推事件且弹出“消息接收中”提示框的事件推送
    PICSYSPHOTO("pic_sysphoto"), // 弹出系统拍照发图的事件推送
    PICPHOTOORALBUM("pic_photo_or_album"), // 弹出拍照或者相册发图的事件推送
    PICWEIXIN("pic_weixin"), // 弹出微信相册发图器的事件推送
    LOCATIONSELECT("location_select"), // 弹出地理位置选择器的事件推送
    TEMPLATESENDJOBFINISH("TEMPLATESENDJOBFINISH"), // 模板消息发送任务完成
    MASSSENDJOBFINISH("MASSSENDJOBFINISH") // 群发消息发送完成

    String value

    EventType(String value) {
        this.value = value
    }

    @Override
    String toString() {
        return this.value
    }

}