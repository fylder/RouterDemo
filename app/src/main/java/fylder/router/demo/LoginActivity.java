package fylder.router.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.ButterKnife;
import butterknife.OnClick;
import fylder.router.demo.config.BookConfig;
import fylder.router.demo.config.Extras;

@Route(path = "/app/LoginActivity", name = "login", priority = 2, extras = Extras.LOGIN)
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.login_btn)
    void toBook() {
        BookConfig.hasLogin = true;
        ARouter.getInstance()
                .build("/app/BookActivity")
                .withString("ahh", "from LoginActivity")
                .navigation();
        finish();
    }
}
