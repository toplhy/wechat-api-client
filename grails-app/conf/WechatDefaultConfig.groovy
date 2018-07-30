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
    // ###=appId   ***=secret   +++=access_token
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

    //template message url
    industrySetUrl = 'https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=+++'
    industryGetUrl = 'https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=+++'
    templateIdsGetUrl = 'https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=+++'
    privateTemplatesGetUrl = 'https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=+++'
    privateTemplateDeleteUrl = 'https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=+++'
    templateMsgSendUrl = 'https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=+++'

}