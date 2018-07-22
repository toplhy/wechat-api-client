package wechat.api.client.enums;

/**
 * 消息类型
 */
public enum  MsgType {

    EVENT("event"), // 事件消息
    TEXT("text"), // 文本消息
    IMAGE("image"), // 图片消息
    VOICE("voice"), // 语音消息
    VIDEO("video"), // 视频消息
    SHORTVIDEO("shortvideo"), // 小视频消息
    LOCATION("location"), // 位置消息
    LINK("link"); // 链接消息

    String value;

    MsgType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
