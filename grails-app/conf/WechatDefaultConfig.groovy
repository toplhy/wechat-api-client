wechat {
    appId = ''
    appSecret = ''
    token = ''
    encodingType='MINGWEN' //明文模式(MINGWEN)、兼容模式(JIANRONG)、密文模式(MIWEN)
    encodingAESKey = ''
    domain = ''
    openId = ''

    // urls
    // ###=appId   ***=secret   +++=access_token   ---=code/refresh_token/lang/type    >>>=openid
    getAccessTokenUrl = 'https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=###&secret=***'
    getWechatServerIpsUrl = 'https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=+++'
    getLong2shortUrl = 'https://api.weixin.qq.com/cgi-bin/shorturl?access_token=+++'

    // menu urls
    createMenuUrl = 'https://api.weixin.qq.com/cgi-bin/menu/create?access_token=+++'
    getMenuUrl = 'https://api.weixin.qq.com/cgi-bin/menu/get?access_token=+++'
    deleteMenuUrl = 'https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=+++'
    createConditionalMenuUrl = 'https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token=+++'
    deleteConditionalMenueUrl = 'https://api.weixin.qq.com/cgi-bin/menu/delconditional?access_token=+++'
    tryMatchMenuUrl = 'https://api.weixin.qq.com/cgi-bin/menu/trymatch?access_token=+++'
    getCurrentMenuInfoUrl = 'https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=+++'

    // template message url
    setIndustryUrl = 'https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=+++'
    getIndustryUrl = 'https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=+++'
    getTemplateIdsUrl = 'https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=+++'
    getPrivateTemplatesUrl = 'https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=+++'
    deletePrivateTemplateUrl = 'https://api.weixin.qq.com/cgi-bin/template/del_private_template?access_token=+++'
    sendTemplateMsgUrl = 'https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=+++'

    // oauth2 url
    getOAuth2Url = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=###'
    getOAuth2AccessTokenUrl = 'https://api.weixin.qq.com/sns/oauth2/access_token?appid=###&secret=***&code=---&grant_type=authorization_code'
    refreshTokenUrl = 'https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=###&grant_type=refresh_token&refresh_token=---'
    getOAuth2UserInfoUrl = 'https://api.weixin.qq.com/sns/userinfo?access_token=+++&openid=>>>&lang=---'
    validateTokenUrl = 'https://api.weixin.qq.com/sns/auth?access_token=+++&openid=>>>'

    // material url
    uploadMediaUrl = 'https://api.weixin.qq.com/cgi-bin/media/upload?access_token=+++&type=---'
    getMediaUrl = 'https://api.weixin.qq.com/cgi-bin/media/get?access_token=+++&media_id=---'
    getMediaVoiceUrl = 'https://api.weixin.qq.com/cgi-bin/media/get/jssdk?access_token=+++&media_id=---'
    addNewsUrl = 'https://api.weixin.qq.com/cgi-bin/material/add_news?access_token=+++'
    updateNewsUrl = 'https://api.weixin.qq.com/cgi-bin/material/update_news?access_token=+++'
    uploadNewsImgUrl = 'https://api.weixin.qq.com/cgi-bin/media/uploadimg?access_token=+++'
    addMaterialUrl = 'https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=+++&type=---'
    getMaterialUrl = 'https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=+++'
    deleteMaterialUrl = 'https://api.weixin.qq.com/cgi-bin/material/del_material?access_token=+++'
    countMaterialUrl = 'https://api.weixin.qq.com/cgi-bin/material/get_materialcount?access_token=+++'
    getMaterialListUrl = 'https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=+++'

    // user url
    createTagUrl = 'https://api.weixin.qq.com/cgi-bin/tags/create?access_token=+++'
    getTagsUrl = 'https://api.weixin.qq.com/cgi-bin/tags/get?access_token=+++'
    updateTagUrl = 'https://api.weixin.qq.com/cgi-bin/tags/update?access_token=+++'
    deleteTagUrl = 'https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=+++'
    getTagUsersUrl = 'https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=+++'
    batchTagUsersUrl = 'https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=+++'
    batchUnTagUsersUrl = 'https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=+++'
    getUserTagsUrl = 'https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=+++'
    updateUserRemarkUrl = 'https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=+++'
    getUserInfoUrl = 'https://api.weixin.qq.com/cgi-bin/user/info?access_token=+++&openid=>>>&lang=---'
    batchGetUserInfoUrl = 'https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=+++'
    getUserListUrl = 'https://api.weixin.qq.com/cgi-bin/user/get?access_token=+++&next_openid=>>>'
    batchBalckUsersUrl = 'https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=+++'
    batchUnBalckUsersUrl = 'https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist?access_token=+++'
    getBlackUserListUrl = 'https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=+++'

    // qrcode url
    createQrCodeUrl = 'https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=+++'
    getQrCodeUrl = 'https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=---'

    // datacube url
    getUserSummaryUrl = 'https://api.weixin.qq.com/datacube/getusersummary?access_token=+++'
    getUserCumulateUrl = 'https://api.weixin.qq.com/datacube/getusercumulate?access_token=+++'
    getArticleSummaryUrl = 'https://api.weixin.qq.com/datacube/getarticlesummary?access_token=+++'
    getArticleTotalUrl = 'https://api.weixin.qq.com/datacube/getarticletotal?access_token=+++'
    getUserReadUrl = 'https://api.weixin.qq.com/datacube/getuserread?access_token=+++'
    getUserReadHourUrl = 'https://api.weixin.qq.com/datacube/getuserreadhour?access_token=+++'
    getUserShareUrl = 'https://api.weixin.qq.com/datacube/getusershare?access_token=+++'
    getUserShareHourUrl = 'https://api.weixin.qq.com/datacube/getusersharehour?access_token=+++'
    getUpstreamMsgUrl = 'https://api.weixin.qq.com/datacube/getupstreammsg?access_token=+++'
    getUpstreamMsgHourUrl = 'https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=+++'
    getUpstreamMsgWeekUrl = 'https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=+++'
    getUpstreamMsgMonthUrl = 'https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=+++'
    getUpstreamMsgDistUrl = 'https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=+++'
    getUpstreamMsgDistWeekUrl = 'https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=+++'
    getUpstreamMsgDistMonthUrl = 'https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=+++'
    getInterfaceSummaryUrl = 'https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=+++'
    getInterfaceSummaryHourUrl = 'https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token=+++'
}