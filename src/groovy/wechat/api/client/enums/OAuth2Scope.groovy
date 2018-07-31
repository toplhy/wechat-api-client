package wechat.api.client.enums

/**
 * 微信网页授权scope
 */
enum OAuth2Scope {

    SNSAPI_BASE("snsapi_base"),
    SNSAPI_USERINFO("snsapi_userinfo")

    String value

    OAuth2Scope(String value) {
        this.value = value
    }

    @Override
    String toString() {
        return this.value
    }
}