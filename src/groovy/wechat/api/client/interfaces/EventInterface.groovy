package wechat.api.client.interfaces

/**
 * Created by Administrator on 2018/7/25.
 */
interface EventInterface {

    /**
     * 回复之前的处理方法
     * @param message
     * @return 要回复返回true， 不回复返回false
     */
    boolean beforeHandleEvent(Map message)

    /**
     *
     * @param message
     * @return 不回复时返回null， 回复时返回要回复的map包
     */
    Map handleEvent(Map message)

    /**
     * 回复之后的处理操作
     * @param message
     */
    void afterHandleEvent(Map message)
}