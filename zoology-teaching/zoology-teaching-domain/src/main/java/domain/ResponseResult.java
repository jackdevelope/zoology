package domain;

import lombok.Data;

/**
 * responseResult响应结果封装工具Bean实体
 * */
@Data
public class ResponseResult {

    private Boolean sign;
    private String state;
    private String message;
    private Object content;

    public ResponseResult() {
    }

    public ResponseResult(Boolean sign, String state, String message, Object content) {
        this.sign = sign;
        this.state = state;
        this.message = message;
        this.content = content;
    }
}
