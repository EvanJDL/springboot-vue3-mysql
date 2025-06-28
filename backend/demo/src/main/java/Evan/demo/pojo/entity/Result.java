package Evan.demo.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public static <T> Result<T> success() {
        return new Result<>(0, "Success", null);
    }

    public static <T> Result<T> success(String message,T data) {
        return new Result<T>(0, message, data);
    }
    public static <T> Result<T> success(T data) {
        return new Result<T>(0, "Success", data);
    }
    public static <T> Result<T> fail(String message) {
        return new Result<T>(1, message, null);
    }
}
