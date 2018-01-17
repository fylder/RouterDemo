package fylder.router.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import butterknife.ButterKnife;
import fylder.router.demo.config.Extras;

@Route(path = "/app/BookActivity", name = "book", priority = 2, extras = Extras.USER)
public class BookActivity extends AppCompatActivity {

    @Autowired
    String ahh = "";
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        ButterKnife.bind(this);
        ARouter.getInstance().inject(this);
        init();
    }

    void init() {
        setResult(200);
        String str = "s:" + ahh;
        textView.setText(str);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
