package util;

import lombok.Data;

@Data
public class ResponseResult {
      private Boolean res;
      private String state;
      private String message;
      private Object content;
      public ResponseResult(){
      }
      public  ResponseResult(Boolean res, String state, String message, Object content) {
            this.res = res;
            this.state = state;
            this.message = message;
            this.content = content;
      }
}
