package util;

public final class ThreadLocalUtil {
    private static final ThreadLocal<String> data = new ThreadLocal<>();

    public static void setData(String data){
        ThreadLocalUtil.data.set(data);
    }

    public static String getData(){
        return data.get();
    }

    // 重要：请求处理完成后必须清理，防止内存泄漏
    public static void clear() {
        ThreadLocalUtil.data.remove();
    }
}
