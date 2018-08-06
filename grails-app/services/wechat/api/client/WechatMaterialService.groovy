package wechat.api.client

import grails.converters.JSON
import grails.transaction.Transactional
import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

@Transactional
class WechatMaterialService extends WechatBaseService{

    /**
     * 生成post form 请求
     * @param file
     * @return
     */
    def geneRequest(File file) {
        HttpHeaders headers = new HttpHeaders()
        headers.setContentType(MediaType.MULTIPART_FORM_DATA)
        headers.setContentDispositionFormData("media", file?.name)
        headers.setContentLength(file.length())

        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, String>()
        map.add("file", new org.springframework.core.io.FileSystemResource(file))

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers)
        return request
    }

    /**
     * 新增临时素材
     * @param file
     * @param type(image、voice、video、thumb)
     * @return
     */
    def uploadMedia(File file, String type) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.uploadMediaUrl?.toString()?.replace("+++", atoken?.toString())?.replace("---", type)
        def result = JSON.parse(this.getRestTemplate().postForObject(url, geneRequest(file), String.class))
        result
    }

    /**
     * 获取临时素材
     * @param mediaId 素材ID
     * @param isVideo 是否视频素材
     * @return 视频返回url， 其他返回字节
     */
    def getMedia(mediaId, isVideo = false) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getMediaUrl?.toString()?.replace("+++", atoken?.toString())?.replace("---", mediaId?.toString())
        if(isVideo) {
            def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
            result
        }else{
            ResponseEntity<String> responseEntity = this.getRestTemplate().getForEntity(url, String.class)
            def fileMap = [:]
            fileMap.filename = responseEntity?.getHeaders()?.get("Content-disposition")?.get(0)?.replace('attachment; filename=', '')?.replace('"','')
            fileMap.filetype = responseEntity?.getHeaders()?.getContentType()
            fileMap.length = responseEntity?.getHeaders()?.getContentLength()
            fileMap.bytes = responseEntity?.getBody()?.getBytes()
            fileMap
        }
    }

    /**
     * todo 测试
     * 高清语音素材获取接口(JSSDK)
     * @param mediaId
     * @return
     */
    def getMediaVoice(mediaId) {
        def fileMap = [:]
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getMediaVoiceUrl?.toString()?.replace("+++", atoken?.toString())?.replace("---", mediaId?.toString())
        ResponseEntity<String> responseEntity = this.getRestTemplate().getForEntity(url, String.class)
        fileMap.filename = responseEntity?.getHeaders()?.get("Content-disposition")?.get(0)?.replace('attachment; filename=', '')?.replace('"','')
        fileMap.filetype = responseEntity?.getHeaders()?.getContentType()
        fileMap.length = responseEntity?.getHeaders()?.getContentLength()
        fileMap.bytes = responseEntity?.getBody()?.getBytes()
        fileMap
    }

    /**
     * todo 测试
     * 新增永久图文素材
     * @param newsJson
     * @return
     */
    def addNews(JSONObject newsJson) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.addNewsUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, newsJson, String.class))
        result
    }

    /**
     * todo 测试
     * 修改永久图文素材
     * @param newsJson
     * @return
     */
    def updateNews(JSONObject newsJson) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.updateNewsUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, newsJson, String.class))
        result
    }

    /**
     * todo 测试
     * 上传图文消息内的图片获取URL
     * @param file
     * @return url
     */
    def uploadNewsImg(File file) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.uploadNewsImgUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, geneRequest(file), String.class))
        result
    }

    /**
     * todo 测试
     * 新增其他类型永久素材
     * @param file
     * @param type(image、voice、video、thumb)
     */
    def addMaterial(File file, String type) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.addMaterialUrl?.toString()?.replace("+++", atoken?.toString())?.replace("---", type)
        if(type != 'video') {
            def result = JSON.parse(this.getRestTemplate().postForObject(url, geneRequest(file), String.class))
            result
        } else {
            // todo 上传视频时还需要post另一个表单
            ""
        }
    }

    /**
     * todo 测试
     * 获取永久素材
     * @param mediaId 素材ID
     * @param isVideoOrNews 是否视频素材或图文素材
     * @return
     */
    def getMaterial(mediaId, isVideoOrNews = false) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getMaterialUrl?.toString()?.replace("+++", atoken?.toString())
        if(isVideoOrNews) {
            def result = JSON.parse(this.getRestTemplate().postForObject(url, (['media_id':mediaId] as JSONObject) ,String.class))
            result
        }else{
            ResponseEntity<String> responseEntity = this.getRestTemplate().getForEntity(url, String.class)
            def fileMap = [:]
            fileMap.filename = responseEntity?.getHeaders()?.get("Content-disposition")?.get(0)?.replace('attachment; filename=', '')?.replace('"','')
            fileMap.filetype = responseEntity?.getHeaders()?.getContentType()
            fileMap.length = responseEntity?.getHeaders()?.getContentLength()
            fileMap.bytes = responseEntity?.getBody()?.getBytes()
            fileMap
        }
    }

    /**
     * todo 测试
     * 删除永久素材
     * @param mediaId
     */
    def delMaterial(mediaId) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.deleteMaterialUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().postForObject(url, (['media_id':mediaId] as JSONObject) ,String.class))
        result
    }

    /**
     * todo 测试
     * 获取素材总数
     * @return
     */
    def countMaterial() {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.countMaterialUrl?.toString()?.replace("+++", atoken?.toString())
        def result = JSON.parse(this.getRestTemplate().getForObject(url, String.class))
        result
    }

    /**
     * todo 测试
     * 获取素材列表(永久素材)
     * @param type (image、voice、video、news)
     * @param offset 偏移量
     * @param count 返回数量
     * @return
     */
    def listMaterial(String type, int offset = 0, int count = 10) {
        def config = this.getWechatConfig()
        def atoken = this.getAccessToken()
        def url = config?.getMaterialListUrl?.toString()?.replace("+++", atoken?.toString())
        def data = ["type": type, "offset": offset, "count": count] as JSONObject
        def result = JSON.parse(this.getRestTemplate().postForObject(url, data, String.class))
        result
    }
}
