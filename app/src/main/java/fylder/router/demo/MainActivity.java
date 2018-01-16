package fylder.router.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fylder.annotation.Test;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 200) {
            Toast.makeText(this, "返回的结果", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.main_btn)
    void onClickRouter() {
        ARouter.getInstance()
                .build("/fylder/router/demo/BookActivity")
                .withString("ahh", "this is a value")
                .navigation(this, 100);
    }

    @Test("test")
    public void test() {

    }
}
