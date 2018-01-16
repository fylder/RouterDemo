package fylder.router.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.ButterKnife;
import butterknife.OnClick;
import fylder.router.demo.config.BookConfig;
import fylder.router.demo.config.Extras;

@Route(path = "/fylder/router/demo/WeChatActivity", name = "WeChat",extras = Extras.WECHAT)
public class WeChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we_chat);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.we_chat_btn)
    void weChatBind() {
        BookConfig.hasBind = true;
        ARouter.getInstance()
                .build("/fylder/router/demo/BookActivity")
                .withString("ahh", "from WeChatActivity")
                .navigation(this, 100);
        finish();
    }
}
