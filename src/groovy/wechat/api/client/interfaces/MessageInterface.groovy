package wechat.api.client.interfaces

/**
 * 被动回复消息接口
 */
interface MessageInterface {

    /**
     * 回复之前的处理方法
     * @param message
     * @return 要回复返回true， 不回复返回false
     */
    boolean beforeHandleMessage(Map message)

    /**
     *
     * @param message
     * @return 不回复时返回null， 回复时返回要回复的map包
     */
    Map handleMessage(Map message)

    /**
     * 回复之后的处理操作
     * @param message
     */
    void afterHandleMessage(Map message)
}