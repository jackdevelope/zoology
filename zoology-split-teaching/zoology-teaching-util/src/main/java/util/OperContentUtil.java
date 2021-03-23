package util;

public enum OperContentUtil {
    operNewSec("detail", "New Section"),

    OperNewles("detail", "New lesson"),

    OperEditSec("detail", "Edit Section"),

    OperEditles("detail", "Edit lesson");

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String detail;
    private String message;

    OperContentUtil(String detail, String message) {
    }
}
