package fylder.lib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/lib/LibraryActivity", name = "Library", priority = 2, extras = 3)
public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.library_btn)
    void hei() {
        ARouter.getInstance()
                .build("/app/BookActivity")
                .withString("ahh", "this is a value")
                .navigation(this, 100);
    }
}
