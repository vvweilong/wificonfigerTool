package locationmanager;

/**
 * Created by zhuxiaolong on 16/3/28.
 */
public interface HttpResponeCallback <T>{
    void onResponeSuccess(T t);
    void onRequestFailure();
}
