package com.example.abutment.config;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.Assert;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.*;


/**
 * @author Liutx
 * @date 2020/10/3 10:34
 * @Description
 */

@Slf4j
public class RestBuilder {
    private static final RestTemplate REST_TEMPLATE;

    private HttpHeaders httpHeaders;

    private String postBodyStr;

    private Map<String, String> restfulPathParamMap;

    private Map<String, String> getParamMap;

    private Map<String, Object> bodyParam;

    private MultiValueMap<String, Object> postParam;

    private HttpEntity<?> httpEntity;

    private String requestPath;

    private static final Gson GSON;

    private Duration readTimeOut;

    private Duration connectTimeOut;

    private Boolean setTimeout = false;

    static {
        REST_TEMPLATE = new RestTemplate();
        GSON = new Gson();

        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        REST_TEMPLATE.getMessageConverters().add(converter);
    }

    private RestBuilder() {
    }

    public static RestBuilder builder() {
        return new RestBuilder();
    }

    /**
     * 添加header
     *
     * @param headerKey key
     * @param value     value
     * @return {@link RestBuilder}
     */
    public RestBuilder header(String headerKey, String value) {
        Assert.hasText(headerKey, "headerKey must not be null");
        if (Objects.isNull(httpHeaders)) {
            httpHeaders = new HttpHeaders();
        }
        httpHeaders.add(headerKey, value);
        return this;
    }

    /**
     * 添加多个header
     *
     * @param headerMap map
     * @return {@link RestBuilder}
     */
    public RestBuilder headers(MultiValueMap<String, String> headerMap) {
        Assert.notEmpty(headerMap, "headerMap must not be null");
        if (Objects.isNull(headerMap)) {
            headerMap = new HttpHeaders();
        }
        this.httpHeaders.addAll(headerMap);
        return this;
    }

    /**
     * 设置Http ContentType
     *
     * @param mediaType {@link MediaType}
     * @return {@link RestBuilder}
     */
    public RestBuilder contentType(MediaType mediaType) {
        if (Objects.isNull(httpHeaders)) {
            httpHeaders = new HttpHeaders();
        }
        httpHeaders.setContentType(mediaType);
        return this;
    }


    /**
     * 设置GET请求参数，URL拼接形式
     *
     * @param getParam key
     * @param value    value
     * @return {@link RestBuilder}
     */
    public RestBuilder getParam(String getParam, String value) {
        Assert.hasText(getParam, "getParam must not be null");
        if (Objects.isNull(getParamMap)) {
            getParamMap = new HashMap<>();
        }
        if (Objects.nonNull(value)) {
            getParamMap.put(getParam, value);
        }
        return this;
    }

    /**
     * 批量设置GET请求参数,URL拼接形式
     *
     * @param getParamMap paramMap
     * @return {@link RestBuilder}
     */
    public RestBuilder getParams(Map<String, String> getParamMap) {
        Assert.notEmpty(getParamMap, "getParamMap must not be null");
        if (Objects.isNull(this.getParamMap)) {
            this.getParamMap = new HashMap<>();
        }
        this.getParamMap.putAll(getParamMap);
        return this;
    }

    /**
     * 设置post表单
     *
     * @param param key
     * @param value value
     * @return {@link RestBuilder}
     */
    public RestBuilder formData(String param, Object value) {
        Assert.hasText(param, "param must not be null");
        if (Objects.isNull(this.postParam)) {
            postParam = new LinkedMultiValueMap<>();
        }
        this.postParam.add(param, value);
        return this;
    }

    /**
     * 批量设置表单
     *
     * @param postParams postParam
     * @return {@link RestBuilder}
     */
    public RestBuilder formDatas(MultiValueMap<String, Object> postParams) {
        Assert.notEmpty(postParams, "PostParams must not be null");
        if (Objects.isNull(this.postParam)) {
            postParam = new LinkedMultiValueMap<>();
        }
        postParam = postParams;
        return this;
    }

    /**
     * 设置body,传输的字符串，可以是json,xml
     *
     * @param postBody postBody
     * @return {@link RestBuilder}
     */
    public RestBuilder postBodyStr(String postBody) {
        Assert.notNull(postBody, "postBody must not be null");
        this.postBodyStr = postBody;
        return this;
    }

    /**
     * 设置body参数，最终会被转换成json
     *
     * @param key   key
     * @param value value
     * @return {@link RestBuilder}
     */
    public RestBuilder postBodyParam(String key, Object value) {
        Assert.hasText(key, "post body param must not be null");
        if (Objects.isNull(bodyParam)) {
            this.bodyParam = new HashMap<>();
        }
        bodyParam.put(key, value);
        return this;
    }

    /**
     * 设置post body最终会被转换成json
     *
     * @param bodyMap bodyMap
     * @return {@link RestBuilder}
     */
    public RestBuilder postBodyParams(Map<String, Object> bodyMap) {
        Assert.notEmpty(bodyMap, "bodyMap must not be null");
        if (Objects.isNull(bodyParam)) {
            this.bodyParam = bodyMap;
        } else {
            this.bodyParam.putAll(bodyMap);
        }
        return this;
    }

    /**
     * 设置请求body，最终会转换成json
     *
     * @param postBodyObj {@link Object}
     * @return {@link RestBuilder}
     */
    public RestBuilder postBodyObj(Object postBodyObj) {
        Assert.notNull(postBodyObj, "postBodyObj must not be null");
        this.postBodyStr = GSON.toJson(postBodyObj);
        return this;
    }

    /**
     * 设置路径参数
     *
     * @param key   key
     * @param value value
     * @return {@link RestBuilder}
     */
    public RestBuilder restFulPathParam(String key, String value) {
        Assert.hasText(key, "key must not be null");
        if (Objects.isNull(restfulPathParamMap)) {
            this.restfulPathParamMap = new HashMap<>();
        }
        restfulPathParamMap.put(key, value);
        return this;
    }

    /**
     * 批量设置路径参数
     *
     * @param restfulPathParamMap paramMap
     * @return {@link RestBuilder}
     */
    public RestBuilder restFulPathParams(Map<String, String> restfulPathParamMap) {
        Assert.notEmpty(restfulPathParamMap, "restfulPathParamMap must not be null");
        if (Objects.isNull(restfulPathParamMap)) {
            this.restfulPathParamMap = new HashMap<>();
        }
        this.restfulPathParamMap.putAll(restfulPathParamMap);
        return this;
    }

    /**
     * 发送POST请求，并返回响应信息
     *
     * @param requestPath  请求路径/url
     * @param responseType 响应类型
     * @param <R>          ResponseType
     * @return response
     */
    public <R> R postForObj(String requestPath, Class<R> responseType) {
        build(requestPath, HttpMethod.POST);
        return getRestTemplate().postForObject(this.requestPath, this.httpEntity, responseType);
    }

    /**
     * 发送POST请求并返回{@link ResponseEntity}
     *
     * @param requestPath  请求路径/url
     * @param responseType 响应类型
     * @param <R>          ResponseType
     * @return response
     */
    public <R> ResponseEntity<R> postForEntity(String requestPath, Class<R> responseType) {
        build(requestPath, HttpMethod.POST);
        return getRestTemplate().postForEntity(this.requestPath, this.httpEntity, responseType);
    }

    /**
     * 发送GET请求并返回响应信息
     *
     * @param requestPath  请求路径/URL
     * @param responseType 响应类型
     * @param <R>          R
     * @return R
     */
    public <R> R getForObj(String requestPath, Class<R> responseType) {
        ResponseEntity<R> responseEntity = getForEntity(requestPath, responseType);
        return responseEntity.getBody();
    }

    /**
     * 发送GET请求并反返回{@link ResponseEntity}
     *
     * @param requestPath  请求路径/URL
     * @param responseType 响应类型
     * @param <R>          R
     * @return R
     */
    public <R> ResponseEntity<R> getForEntity(String requestPath, Class<R> responseType) {
        build(requestPath, HttpMethod.GET);
        // 构造execute()执行所需要的参数。
        RequestCallback requestCallback = REST_TEMPLATE.httpEntityCallback(this.httpEntity, responseType);
        ResponseExtractor<ResponseEntity<R>> entityResponseExtractor = REST_TEMPLATE.responseEntityExtractor(responseType);
        // 执行execute()，发送请求
        return getRestTemplate().execute(this.requestPath, HttpMethod.GET, requestCallback, entityResponseExtractor);
    }

    /**
     * 获取restTemplate
     *
     * @return RestTemplate
     */
    private RestTemplate getRestTemplate() {
        if (!setTimeout) {
            return RestBuilder.REST_TEMPLATE;
        }
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        if (Objects.nonNull(this.readTimeOut)) {
            restTemplateBuilder.setReadTimeout(readTimeOut);
        }
        if (Objects.nonNull(this.connectTimeOut)) {
            restTemplateBuilder.setConnectTimeout(connectTimeOut);
        }
        return restTemplateBuilder.build();
    }

    /**
     * 设置readTimeOut
     * [注意]如果设置超时时间会导致每次请求的时候都会创建{@link RestTemplate}
     *
     * @param readTimeOut readTimeOut
     * @return {@link RestBuilder}
     */
    public RestBuilder readTimeOut(Duration readTimeOut) {
        this.setTimeout = true;
        this.readTimeOut = readTimeOut;
        return this;
    }

    /**
     * 设置ConnectTimeOut
     * [注意]如果设置超时时间会导致每次请求的时候都会创建{@link RestTemplate}
     *
     * @param connectTimeOut connectTimeOut
     * @return {@link RestBuilder}
     */
    public RestBuilder connectTimeOut(Duration connectTimeOut) {
        this.setTimeout = true;
        this.connectTimeOut = connectTimeOut;
        return this;
    }

    /**
     * 构造restful路径
     *
     * @param path path
     * @return restful path
     */
    private String generatePath(String path) {
        if (Objects.nonNull(restfulPathParamMap) && !restfulPathParamMap.isEmpty()) {
            // 替换restful值
            Set<Map.Entry<String, String>> entrySet = restfulPathParamMap.entrySet();
            for (Map.Entry<String, String> entry : entrySet) {
                path = path.replace(String.format("${%s}", entry.getKey()), entry.getValue());
            }
        }
        if (Objects.nonNull(getParamMap) && !getParamMap.isEmpty()) {
            StringBuilder pathBuilder = new StringBuilder(path).append("?");
            // 拼接请求值
            getParamMap.forEach((k, v) -> pathBuilder.append(k).append("=").append(v).append("&"));
            // 最后一个&
            int length = pathBuilder.length();
            pathBuilder.delete(length - 1, length);
            path = pathBuilder.toString();
        }
        if (log.isDebugEnabled()) {
            log.debug("PATH [ {} ]", path);
        }
        return path;
    }

    /**
     * 构造http的URL和body
     *
     * @param path       请求路径
     * @param httpMethod 请求方法
     */
    private void build(String path, HttpMethod httpMethod) {
        // 构造请求路径
        this.requestPath = generatePath(path);
        Object body = null;
        if (httpMethod.matches(HttpMethod.POST.name())) {
            MediaType contentType = httpHeaders.getContentType();
            if (Objects.isNull(contentType)) {
                // 不设置content-type默认为ALL,并只从postBodyStr中获取body
                httpHeaders.setContentType(MediaType.ALL);
                body = postBodyStr;
            } else if (MediaType.APPLICATION_JSON.equals(contentType)) {
                // 请求方式为json
                if (Objects.nonNull(bodyParam) && !bodyParam.isEmpty()) {
                    // 如果设置map，map为准
                    body = GSON.toJson(bodyParam);
                } else {
                    body = postBodyStr;
                }
            } else if (MediaType.APPLICATION_FORM_URLENCODED.equals(contentType)) {
                // 请求方式为form-data
                body = postParam;
            }
        }
        this.httpEntity = new HttpEntity<>(body, httpHeaders);
        if (log.isDebugEnabled()) {
            log.debug("requestEntity [ {} ]", httpEntity.toString());
        }
    }
}
