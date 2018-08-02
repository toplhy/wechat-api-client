wechat {
    appId = ''
    appSecret = ''
    token = ''
    encodingType='MINGWEN' //明文模式(MINGWEN)、兼容模式(JIANRONG)、密文模式(MIWEN)
    encodingAESKey = ''
    domain = ''
    openId = ''
    welcome = ''

    // urls
    // ###=appId   ***=secret   +++=access_token   ---=code/refresh_token/lang/type    >>>=openid
    accessTokenUrl = 'https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=###&secret=***'
    wechatServerIpsUrl = 'https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=+++'
    long2shortUrl = 'https://api.weixin.qq.com/cgi-bin/shorturl?access_token=+++'
    // menu urls
    menuCreateUrl = 'https://api.weixin.qq.com/cgi-bin/menu/create?access_token=+++'
    menuGetUrl = 'https://api.weixin.qq.com/cgi-bin/menu/get?access_token=+++'
    menuDeleteUrl = 'https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=+++'
    conditionalMenuCreateUrl = 'https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=+++'
    conditionalMenuDeleteUrl = 'https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=+++'
    menuTrymatchUrl = 'https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=+++'
    currentMenuInfoUrl = 'https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=+++'

    // template message url
    industrySetUrl = 'https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=+++'
    industryGetUrl = 'https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=+++'
    templateIdsGetUrl = 'https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=+++'
    privateTemplatesGetUrl = 'https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=+++'
    privateTemplateDeleteUrl = 'https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=+++'
    templateMsgSendUrl = 'https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=+++'

    // oauth2 url
    oAuth2GetUrl = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=###'
    oAuth2AccessTokenUrl = 'https://api.weixin.qq.com/sns/oauth2/access_token?appid=###&secret=***&code=---&grant_type=authorization_code'
    tokenRefreshUrl = 'https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=###&grant_type=refresh_token&refresh_token=---'
    userInfoUrl = 'https://api.weixin.qq.com/sns/userinfo?access_token=+++&openid=>>>&lang=---'
    tokenValidateUrl = 'https://api.weixin.qq.com/sns/auth?access_token=+++&openid=>>>'

    // material url
    meidaUploadUrl = 'https://api.weixin.qq.com/cgi-bin/media/upload?access_token=+++&type=---'
    mediaGetUrl = 'https://api.weixin.qq.com/cgi-bin/media/get?access_token=+++&media_id=---'
    mediaVoiceGetUrl = 'https://api.weixin.qq.com/cgi-bin/media/get/jssdk?access_token=+++&media_id=---'
    newsAddUrl = 'https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=+++'
    newsUpdateUrl = 'https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=+++'
    newsImgUploadUrl = 'https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=+++'
    materialAddUrl = 'https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=+++&type=---'
    materialGetUrl = 'https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=+++'
    materialDelUrl = 'https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=+++'
    mateerialCountUrl = 'https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=+++'
    materialListUrl = 'https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=+++'
}