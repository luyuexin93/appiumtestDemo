package com.demo.springboot.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/** 
* @author 作者luyuexin: 
* @version 创建时间：2020年4月7日 下午10:11:24 
* 类说明 
*/

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "返回结果")
@JsonPropertyOrder({"result", "content"})
public class RestResponse {
	@ApiModelProperty("消息")
	private Object content ;
	@ApiModelProperty("响应消息")
	
	private  RequestResult requestResult;
	
	public  RestResponse() {
		requestResult = new RequestResult();
		requestResult.setSuccess(true);
	}
	@JsonProperty("content")
	public Object getContent() {
		return content;
	}
    @JsonProperty("content")
	public void setContent(Object content) {
		this.content = content;
	}
	@JsonProperty("result")
	public RequestResult getRequestResult() {
		return requestResult;
	}
	@JsonProperty("result")
	public void setRequestResult(RequestResult requestResult) {
		this.requestResult = requestResult;
	}
	
	
	
	
	
	
	// TO-DO
	// https://blog.csdn.net/weixin_34403693/article/details/91393634
	// 格式化响应消息
}
