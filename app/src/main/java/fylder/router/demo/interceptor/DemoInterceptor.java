package fylder.router.demo.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.launcher.ARouter;

import fylder.router.demo.config.BookConfig;
import fylder.router.demo.config.Extras;

/**
 * Created by fylder on 2018/1/16.
 */
@Interceptor(priority = 4, name = "is we_chat user")
public class DemoInterceptor implements IInterceptor {

    Context mContext;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {

        //非登录和绑定页面需验证是否绑定
        if (postcard.getExtra() != Extras.LOGIN && postcard.getExtra() != Extras.WECHAT && !BookConfig.hasBind) {
            //跳转登录界面
            ARouter.getInstance()
                    .build("/app/WeChatActivity")
                    .withString("ahh", "this is a value").navigation();
            callback.onInterrupt(null);
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}
