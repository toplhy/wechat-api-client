# wechat-api-client
一款grails插件
---
+ [WeixinController](#weixinMark)
+ [WechatBaseService](#wechatBaseMark)
+ [WechatMenuService](#wechatMenuMark)
+ [WechatMessageService](#wechatMessageMark)
+ [WechatOAuth2Service](#wechatOAuth2Mark)
+ [WechatMaterialService](#wechatMaterialMark)
+ [WechatUserService](#wechatUserMark)
+ [WechatQrCodeService](#wechatQrCodeMark)
+ [WechatDatacubeService](#wechatDatacubeMark)

---
#### <span id="weixinMark"></span>WeixinController
&emsp;&emsp;在填写服务器配置时,在服务器地址（URL）一栏填写“http://yourdomain/yourapp/weixin/index”,例如“http://toplhyi.oicp.io/wechatDemo/weixin/index”,微信服务器将会发送验证请求到该URL，并在验证通过后用户每次向公众号发送消息、或者产生自定义菜单、或产生微信支付订单等情况时，该URL将得到微信服务器推送过来的消息和事件。

&emsp;&emsp;方法中对微信推送过来的消息和事件进行了处理，如果要响应这些消息和事件，需要实现MessageInterface和EventInterface接口，且实现类命名须为“wechat.api.client.impl.MessageInterfaceImpl”和“wechat.api.client.impl.EventInterfaceImpl”。

---
#### <span id="wechatBaseMark"></span>WechatBaseService

方法|传入参数|方法描述
---|---|---
getWechatConfig|无|获取配置文件信息
getAccessToken|无|获取access_token
getWechatServerIps|无|获取微信服务器IP地址
getShortUrl|String longUrl|长链接转短链接


---
#### <span id="wechatMenuMark"></span>WechatMenuService

方法|传入参数|方法描述
---|---|---
createMenu|JSONObject menuJson|自定义菜单创建
getMenu|无|自定义菜单查询
deleteMenu|无|自定义菜单删除
createConditionalMenu|JSONObject menuJson|个性化菜单创建
deleteConditionalMenu|String menuId|个性化菜单删除
trymatchMenu|String userId|个性化菜单匹配结果测试
getCurrentMenuInfo|无|获取自定义菜单配置


---
#### <span id="wechatMessageMark"></span>WechatMessageService（目前只实现了模板消息相关接口）

方法|传入参数|方法描述
---|---|---
setIndustry|String industryId1 <br/> String industryId2|设置所属行业
getIndustry|无|获取设置的行业信息
getTemplateIds|String templateId|获得模板ID
getPrivateTemplates|无|获取已添加至帐号下模板列表
deletePrivateTemplate|String templateId|删除已添加至账号的模板
sendTemplateMsg|JSONObject msgJson|发送模板消息


---
#### <span id="wechatOAuth2Mark"></span>WechatOAuth2Service

方法|传入参数|方法描述
---|---|---
getOAuth2Url|String redirectUrl <br/> OAuth2Scope scope <br/> String state|获取网页授权链接
getOAuth2AccessToken|String code|通过code换取网页授权access_token
refreshAccessToken|String refreshToken|刷新网页授权access_token
getUserInfo|String accessToken <br/> String openId <br/> String lang = 'zh_CN'|获取用户信息
validateAccessToken|String accessToken <br/> String openId|检验授权凭证（access_token）是否有效


---
#### <span id="wechatMaterialMark"></span>WechatMaterialService(部分方法未测试)

方法|传入参数|方法描述
---|---|---
uploadMedia|File file <br/> String type|新增临时素材
getMedia|String mediaId <br/> boolean isVideo = false|获取临时素材
getMediaVoice（未测试）|String mediaId|高清语音素材获取接口(JSSDK)
addNews（未测试）|JSONObject newsJson|新增永久图文素材
updateNews（未测试）|JSONObject newsJson|修改永久图文素材
uploadNewsImg（未测试）|File file|上传图文消息内的图片获取URL
addMaterial（未完成）|File file <br/> String type|新增其他类型永久素材
getMaterial（未测试）|String mediaId <br/> boolean isVideoOrNews = false|获取永久素材
delMaterial（未测试）|String mediaId|删除永久素材
countMaterial（未测试）|无|获取素材总数
listMaterial（未测试）|String type <br/> int offset = 0 <br/> int count = 10|获取素材列表(永久素材)


---
#### <span id="wechatUserMark"></span>WechatUserService

方法|传入参数|方法描述
---|---|---
createTag|String tagName|创建标签
updateTag|String tagId <br/> String tagName|编辑标签
deleteTag|String tagId|删除标签
getTags|无|获取公众号已创建的标签
getTagUsers|String tagId <br/> String nextOpenId = ""|获取标签下粉丝列表
batchTagUser|String tagId <br/> List openIdList|批量为用户打标签
batchUnTagUser|String tagId <br/> List openIdList|批量为用户取消标签
getUserTags|String openId|获取用户身上的标签列表
setUserRemark|String openId <br/> String remark|设置用户备注名
getUserInfo|String openId <br/> String lang = 'zh_CN'|获取用户基本信息
batchGetUserInfo|List openIdList <br/> String lang = 'zh_CN'|批量获取用户基本信息
getUserList|String nextOpenId = ""|获取用户列表
batchBlackUser|List openIdList|拉黑用户
batchUnBlackUser|List openIdList|取消拉黑用户
getBlackUserList|String nextOpenId = ""|获取公众号的黑名单列表


---
#### <span id="wechatQrCodeMark"></span>WechatQrCodeService

方法|传入参数|方法描述
---|---|---
createQrCode|String senceType <br/> String senceValue <br/> int expireSeconds = 30|创建临时二维码
createLimitQrCode|String senceType <br/> String senceValue|创建永久二维码
getQrCode|String ticket|通过ticket换取二维码


---
#### <span id="wechatDatacubeMark"></span>WechatDatacubeService

方法|传入参数|方法描述
---|----|---
getUserSummary|Date beginDate <br/> Date endDate|获取用户增减数据(最大时间跨度7天)
getUserCumulate|Date beginDate <br/> Date endDate|获取累计用户数据(最大时间跨度7天)
getArticleSummary|Date date|获取图文群发每日数据(最大时间跨度1天)
getArticleTotal|Date date|获取图文群发总数据(最大时间跨度1天)
getUserRead|Date beginDate <br/> Date endDate|获取图文统计数据(最大时间跨度3天)
getUserReadHour|Date date|获取图文统计分时数据(最大时间跨度1天)
getUserShare|Date beginDate <br/> Date endDate|获取图文分享转发数据(最大时间跨度7天)
getUserShareHour|Date date|获取图文分享转发分时数据(最大时间跨度1天)
getUpstreamMsg|Date beginDate <br/> Date endDate|获取消息发送概况数据(最大时间跨度7天)
getUpstreamMsgHour|Date date|获取消息分送分时数据(最大时间跨度1天)
getUpstreamMsgWeek|Date beginDate <br/> Date endDate|获取消息发送周数据(最大时间跨度30天)
getUpstreamMsgMonth|Date beginDate <br/> Date endDate|获取消息发送周数据(最大时间跨度30天)
getUpstreamMsgDist|Date beginDate <br/> Date endDate|获取消息发送分布数据(最大时间跨度15天)
getUpstreamMsgDistWeek|Date beginDate <br/> Date endDate|获取消息发送分布周数据(最大时间跨度30天)
getUpstreamMsgDistMonth|Date beginDate <br/> Date endDate|获取消息发送分布月数据(最大时间跨度30天)
getInterfaceSummary|Date beginDate <br/> Date endDate|获取接口分析数据(最大时间跨度30天)
getInterfaceSummaryHour|Date date|获取接口分析分时数据(最大时间跨度1天)








