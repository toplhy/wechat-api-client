package wechat.api.client.interfaces

interface MessageInterface {

    /**
     * 文本消息
     */
    Boolean beforeHandleText(Map message)

    Map handleText(Map message)

    Boolean afterHandleText(Map message)

    /**
     * 图片消息
     */
    Boolean beforeHandleImage(Map message)

    Map handleImage(Map message)

    Boolean afterHandleImage(Map message)

    /**
     * 语音消息
     */
    Boolean beforeHandleVoice(Map message)

    Map handleVoice(Map message)

    Boolean afterHandleVoice(Map message)

    /**
     * 视频/小视频消息
     */
    Boolean beforeHandleVideo(Map message)

    Map handleVideo(Map message)

    Boolean afterHandleVideo(Map message)

    /**
     * 位置消息
     */
    Boolean beforeHandleLocation(Map message)

    Map handleLocation(Map message)

    Boolean afterHandleLocation(Map message)

    /**
     * 链接消息
     */
    Boolean beforeHandleLink(Map message)

    Map handleLink(Map message)

    Boolean afterHandleLink(Map message)
}