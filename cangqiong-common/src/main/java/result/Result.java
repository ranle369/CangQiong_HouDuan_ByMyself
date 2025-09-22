package result;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;

//      程序进行加载时候会先加载类的静态方法，但是此时静态方法如果没有第一个<T>
//      就不知道之后那些泛型是什么了，所以对于静态方法必须加上第一个泛型<T>
    public static <T>Result<T> success(){
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<T>();
        result.code = 1;
        result.data = data;
        return result;
    }

    public static <T> Result<T> error(String msg){
        Result<T> result = new Result<T>();
        result.code = 0;
        result.msg = msg;
        return result;
    }
}
