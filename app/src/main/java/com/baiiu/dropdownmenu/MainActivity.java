package com.baiiu.dropdownmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.baiiu.dropdownmenu.entity.FilterUrl;
import com.baiiu.filter.DropDownMenu;
import com.baiiu.filter.interfaces.OnFilterDoneListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements OnFilterDoneListener {

    @Bind(R.id.dropDownMenu)
    DropDownMenu dropDownMenu;

/*    @Bind(R.id.mFilterContentView)
    TextView mFilterContentView;*/
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toolbar toolbar = ButterKnife.findById(this, R.id.toolbar);
        setSupportActionBar(toolbar);

        initFilterDropDownView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        List<String> data = new ArrayList<>();
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        data.add("5");
        data.add("6");
        data.add("7");
        data.add("8");
        data.add("9");
        recyclerView.setAdapter(new ListAdapter(data));
    }

    private void initFilterDropDownView() {
        String[] titleList = new String[]{"第一个", "第二个"};
        dropDownMenu.setMenuAdapter(new DropMenuAdapter(this, titleList, this));
    }

    @Override
    public void onFilterDone(int position, String positionTitle, String urlValue) {
        if (position != 3) {
            dropDownMenu.setPositionIndicatorText(FilterUrl.instance().position, FilterUrl.instance().positionTitle);
        }

        dropDownMenu.close();
        Toast.makeText(MainActivity.this,FilterUrl.instance().toString(),Toast.LENGTH_LONG).show();
        //mFilterContentView.setText(FilterUrl.instance().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FilterUrl.instance().clear();
    }
}
