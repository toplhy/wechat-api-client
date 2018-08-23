# wechat-api-client
微信公众号快速开发grails插件（grails-2.5.6）
---

## 使用

#### 项目配置文件
在你的项目的配置文件的wechat.api.client闭包中配置：
```$xslt
wechat {
     api {
         client {
             appId = ""
             appSecret = ""
             token = ""
             encodingType = "MINGWEN" //明文模式(MINGWEN)、兼容模式(JIANRONG)、密文模式(MIWEN)
             encodingAESKey = ""
         }
     }
 }
```

---
#### 微信公众平台配置
&emsp;&emsp;在填写服务器配置时,在服务器地址（URL）一栏填写`http://yourdomain/yourapp/weixin/index` ,例如`http://toplhyi.oicp.io/wechatDemo/weixin/index` ,微信服务器将会发送验证请求到该URL，并在验证通过后用户每次向公众号发送消息、或者产生自定义菜单、或产生微信支付订单等情况时，该URL将得到微信服务器推送过来的消息和事件。

&emsp;&emsp;方法中对微信推送过来的消息和事件进行了处理，如果要响应这些消息和事件，需要实现MessageInterface和EventInterface接口，且实现类命名须为“wechat.api.client.impl.MessageInterfaceImpl”和“wechat.api.client.impl.EventInterfaceImpl”。

---
#### 方法
##### WechatBaseService

方法|传入参数|参数描述|方法描述
---|---|---|---
getWechatConfig|无|无|获取配置文件信息
getAccessToken|无|无|获取access_token
getWechatServerIps|无|无|获取微信服务器IP地址
getShortUrl|String longUrl|长连接Url|长链接转短链接


---
##### WechatMenuService

方法|传入参数|参数描述|方法描述
---|---|---|---
createMenu|JSONObject menuJson|菜单Json数据|自定义菜单创建
getMenu|无|无|自定义菜单查询
deleteMenu|无|无|自定义菜单删除
createConditionalMenu|JSONObject menuJson|菜单Json数据|个性化菜单创建
deleteConditionalMenu|String menuId|菜单Id|个性化菜单删除
trymatchMenu|String userId|用户Id（可以是openId，也可以是微信号）|个性化菜单匹配结果测试
getCurrentMenuInfo|无|无|获取自定义菜单配置


---
##### WechatMessageService（目前只实现了模板消息相关接口）

方法|传入参数|参数描述|方法描述
---|---|---|---
setIndustry|String industryId1, <br/> String industryId2|行业编号1，<br/>行业编号2|设置所属行业
getIndustry|无|无|获取设置的行业信息
getTemplateIds|String templateId|模板库中模板的编号|获得模板ID
getPrivateTemplates|无|无|获取已添加至帐号下模板列表
deletePrivateTemplate|String templateId|模板Id|删除已添加至账号的模板
sendTemplateMsg|JSONObject msgJson|消息Json数据|发送模板消息


---
##### WechatOAuth2Service

方法|传入参数|参数描述|方法描述
---|---|---|---
getOAuth2Url|String redirectUrl, <br/> OAuth2Scope scope, <br/> String state|重定向的回调链接,<br/>应用授权作用域,<br/>state参数|获取网页授权链接
getOAuth2AccessToken|String code|网页授权微信返回的code参数|通过code换取网页授权access_token
refreshAccessToken|String refreshToken|通过getOAuth2AccessToken方法获取到的refresh_token参数|刷新网页授权access_token
getUserInfo|String accessToken, <br/> String openId, <br/> String lang = 'zh_CN'|网页授权接口调用凭证,<br/>用户openId,<br/>国家地区语言版本|获取用户信息
validateAccessToken|String accessToken, <br/> String openId|网页授权接口调用凭证,<br/>用户openId|检验授权凭证（access_token）是否有效


---
##### WechatMaterialService(部分方法未测试)

方法|传入参数|参数描述|方法描述
---|---|---|---
uploadMedia|File file, <br/> String type|临时素材文件,<br/>文件类型（image、voice、video、thumb）|新增临时素材
getMedia|String mediaId, <br/> boolean isVideo = false|临时素材Id，是否视频素材（默认为否）|获取临时素材
getMediaVoice（未测试）|String mediaId|临时素材Id|高清语音素材获取接口(JSSDK)
addNews（未测试）|JSONObject newsJson|图文素材Json数据|新增永久图文素材
updateNews（未测试）|JSONObject newsJson|图文素材Json数据|修改永久图文素材
uploadNewsImg（未测试）|File file|素材文件|上传图文消息内的图片获取URL
addMaterial（未完成）|File file, <br/> String type|素材文件,<br/>文件类型（image、voice、video、thumb）|新增其他类型永久素材
getMaterial（未测试）|String mediaId, <br/> boolean isVideoOrNews = false|素材Id,<br/>是否视频或图文素材（默认为否）|获取永久素材
delMaterial（未测试）|String mediaId|素材Id|删除永久素材
countMaterial（未测试）|无|无|获取素材总数
listMaterial（未测试）|String type, <br/> int offset = 0, <br/> int count = 10|素材类型（image、voice、video、news）,<br/>偏移量（默认0）,<br/>返回数量（默认10）|获取素材列表(永久素材)


---
##### WechatUserService

方法|传入参数|参数描述|方法描述
---|---|---|---
createTag|String tagName|标签名称|创建标签
updateTag|String tagId,<br/> String tagName|标签Id,<br/>新标签名称|编辑标签
deleteTag|String tagId|标签Id|删除标签
getTags|无|无|获取公众号已创建的标签
getTagUsers|String tagId ,<br/> String nextOpenId = ""|标签Id,<br/>起始用户openId（默认为空,从头拉取）|获取标签下粉丝列表
batchTagUser|String tagId, <br/> List openIdList|标签Id,<br/>用户openId列表|批量为用户打标签
batchUnTagUser|String tagId, <br/> List openIdList|标签Id,<br/>用户openId列表|批量为用户取消标签
getUserTags|String openId|用户openId|获取用户身上的标签列表
setUserRemark|String openId, <br/> String remark|用户openId,<br/>用户备注名称|设置用户备注名
getUserInfo|String openId, <br/> String lang = 'zh_CN'|用户openId,<br/>国家地区语言（默认中文）|获取用户基本信息
batchGetUserInfo|List openIdList, <br/> String lang = 'zh_CN'|用户openId列表,<br/>国家地区语言（默认中文）|批量获取用户基本信息
getUserList|String nextOpenId = ""|起始用户openId（默认为空，从头拉取）|获取用户列表
batchBlackUser|List openIdList|用户openId列表|拉黑用户
batchUnBlackUser|List openIdList|用户openId列表|取消拉黑用户
getBlackUserList|String nextOpenId = ""|起始用户openId（默认为空，从头拉取）|获取公众号的黑名单列表


---
##### WechatQrCodeService

方法|传入参数|参数描述|方法描述
---|---|---|---
createQrCode|String senceType, <br/> String senceValue, <br/> int expireSeconds = 30|场景类型（INT/STR）,<br/>场景值,<br/>过期时间（默认30秒）|创建临时二维码
createLimitQrCode|String senceType, <br/> String senceValue|场景类型（INT/STR）,<br/>场景值|创建永久二维码
getQrCode|String ticket|换取二维码的票据|通过ticket换取二维码


---
##### WechatDatacubeService

方法|传入参数|参数描述|方法描述
---|---|---|---
getUserSummary|Date beginDate, <br/> Date endDate|开始时间,<br/>结束时间|获取用户增减数据(最大时间跨度7天)
getUserCumulate|Date beginDate, <br/> Date endDate|开始时间,<br/>结束时间|获取累计用户数据(最大时间跨度7天)
getArticleSummary|Date date|要获取的时间|获取图文群发每日数据(最大时间跨度1天)
getArticleTotal|Date date|要获取的时间|获取图文群发总数据(最大时间跨度1天)
getUserRead|Date beginDate, <br/> Date endDate|开始时间,<br/>结束时间|获取图文统计数据(最大时间跨度3天)
getUserReadHour|Date date|要获取的时间|获取图文统计分时数据(最大时间跨度1天)
getUserShare|Date beginDate, <br/> Date endDate|开始时间,<br/>结束时间|获取图文分享转发数据(最大时间跨度7天)
getUserShareHour|Date date|要获取的时间|获取图文分享转发分时数据(最大时间跨度1天)
getUpstreamMsg|Date beginDate, <br/> Date endDate|开始时间,<br/>结束时间|获取消息发送概况数据(最大时间跨度7天)
getUpstreamMsgHour|Date date|要获取的时间|获取消息分送分时数据(最大时间跨度1天)
getUpstreamMsgWeek|Date beginDate, <br/> Date endDate|开始时间,<br/>结束时间|获取消息发送周数据(最大时间跨度30天)
getUpstreamMsgMonth|Date beginDate, <br/> Date endDate|开始时间,<br/>结束时间|获取消息发送周数据(最大时间跨度30天)
getUpstreamMsgDist|Date beginDate, <br/> Date endDate|开始时间,<br/>结束时间|获取消息发送分布数据(最大时间跨度15天)
getUpstreamMsgDistWeek|Date beginDate, <br/> Date endDate|开始时间,<br/>结束时间|获取消息发送分布周数据(最大时间跨度30天)
getUpstreamMsgDistMonth|Date beginDate, <br/> Date endDate|开始时间,<br/>结束时间|获取消息发送分布月数据(最大时间跨度30天)
getInterfaceSummary|Date beginDate, <br/> Date endDate|开始时间,<br/>结束时间|获取接口分析数据(最大时间跨度30天)
getInterfaceSummaryHour|Date date|要获取的时间|获取接口分析分时数据(最大时间跨度1天)








