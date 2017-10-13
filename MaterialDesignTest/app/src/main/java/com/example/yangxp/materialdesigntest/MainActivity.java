package com.example.yangxp.materialdesigntest;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.yangxp.materialdesigntest.adapter.FruitAdapter;
import com.example.yangxp.materialdesigntest.model.Fruit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private DrawerLayout drawerLayout;

    private Fruit[] fruits = {
            new Fruit("apple",R.drawable.apple),
            new Fruit("banana",R.drawable.banana),
            new Fruit("orange",R.drawable.orange),
            new Fruit("kiwi",R.drawable.kiwi1),
            new Fruit("mango",R.drawable.mango),
            new Fruit("papaya",R.drawable.papaya),
            new Fruit("watermelon",R.drawable.watermelon),
    };

    public static Map<String,String> map = new HashMap<String,String>(){{
        put("orange","橘（英语：Mandarin orange；学名：Citrus reticulata）是芸香科柑桔属的一种水果。“橘”（jú）和“桔”（jié）都是现代汉语规范字，然“桔”作橘子一义时，为“橘”的俗写[1]。在广东的一些方言中二字同音，“桔”也曾做过“橘”的二简字。闽南语称橘为柑仔。西南官话区的各方言中呼为“柑子”或“柑儿”。\n" +
                "“柑橘”与“橘柑”不同：“柑橘”可以指柑橘属所有水果，包括柚、柑、橘、橙等；而“橘柑”在有些方言中和橘子同义。\n" +
                "柑和橘都属于芸香科柑橘属的宽皮柑橘类，果实外皮肥厚，内藏瓤瓣，由汁泡和种子构成。李时珍在《本草纲目·果部》中记载：“橘实小，其瓣味微醋（即酸），其皮薄而红，味辛而苦；柑大于橘，其瓣味酢，其皮稍厚而黄，叶辛而甘。”一般说来，柑的果形正圆，黄赤色，皮紧纹细不易剥，多汁甘香；橘的果形扁圆，红或黄色，皮薄而光滑易剥，味微甘酸。柑和橘虽有区别，但在日常语言中常混用，如广柑也说广橘，蜜橘也说蜜柑。\n" +
                "橘子中的维生素A还能够增强人体在黑暗环境中的视力和治疗夜盲症。橘子不宜食用过量，吃太多会患有胡萝卜素血症，皮肤呈深黄色，如同黄疸一般。若因吃太多橘子造成手掌变黄，只要停吃一段时间，就能让肤色渐渐恢复正常。明代张岱季叔张烨芳对橘子情有独钟，据载其“性好啖橘，橘熟，堆砌床案间，无非橘者，自刊不给，辄命数僮环立剥之”，吃到手脚都呈现黄色。");
        put("apple","苹果（学名：Malus pumila）是水果的一种，是蔷薇科苹果亚科苹果属植物，其树为落叶乔木。苹果的果实富含矿物质和维生素，是人们经常食用的水果之一。\n" +
                "苹果是一种低热量食物，每100克只产生60千卡热量。苹果中营养成分可溶性大，易被人体吸收，故有“活水”之称，其有利于溶解硫元素，使皮肤润滑柔嫩[1]  。据说“每天一苹果，医生远离我”。\n" +
                "根据联合国粮农组织统计，2013年全世界的苹果产量为8082万吨，超过葡萄的7718万吨，排世界第二位（第一位是香蕉：1.067亿吨）[2]  。毫无疑问，苹果是温带水果之王[2]  。\n" +
                "苹果营养丰富，相当于补品。");

        put("banana","香蕉（学名：Musa nana Lour.）芭蕉科芭蕉属植物，又指其果实。热带地区广泛栽培食用。香蕉味香、富含营养，终年可收获，在温带地区也很受重视。植株为大型草本，从根状茎发出，由叶鞘下部形成高3～6公尺(10～20尺)的假杆；叶长圆形至椭圆形，有的长达3～3.5公尺(10～11.5尺)，宽65公分(26寸)，10～20枚簇生茎顶。穗状花序下垂[1]  ，由假杆顶端抽出，花多数，淡黄色；果序弯垂，结果10～20串，约50～150个。植株结果后枯死，由根状茎长出的吸根继续繁殖，每一根株可活多年。原产亚洲东南部：台湾、海南、广东、广西等地区均有栽培。[1] ");
        put("mango","芒果是杧果[1]  （中国植物志）的通俗名（拉丁学名：Mangifera indica L.），芒果是一种原产印度的漆树科常绿大乔木，叶革质，互生；花小，杂性，黄色或淡黄色，成顶生的圆锥花序。核果大，压扁，长5-10厘米，宽3-4.5厘米，成熟时黄色，味甜，果核坚硬。\n" +
                "芒果为著名热带水果之一，芒果果实含有糖、蛋白质、粗纤维，芒果所含有的维生素A的前体胡萝卜素成分特别高，是所有水果中少见的。其次维生素C含量也不低。矿物质、蛋白质、脂肪、糖类等，也是其主要营养成分。可制果汁、果酱、罐头、腌渍、酸辣泡菜及芒果奶粉、蜜饯等");
        put("papaya","木瓜（学名：Chaenomeles sinensis (Thouin)Koehne）：蔷薇科木瓜属，灌木或小乔木，高达5－10米，叶片椭圆卵形或椭圆长圆形，稀倒卵形，长5－8厘米，宽3.5－5.5厘米，叶柄长5－10毫米，微被柔毛，有腺齿；果实长椭圆形，长10－15厘米，暗黄色，木质，味芳香，果梗短。花期4月，果期9－10月。\n" +
                "产山东、陕西、河南（桐柏）、湖北、江西、安徽、江苏、浙江、广东、广西。[1] \n" +
                "习见栽培供观赏，果实味涩，水煮或浸渍糖液中供食用，入药有解酒、去痰、顺气、止痢之效。果皮干燥后仍光滑，不皱缩，故有光皮木瓜之称。木材坚硬可作床柱用。[1] \n" +
                "另有一原产南美洲的物种“番木瓜”十七世纪传入我国，如今已成为大众化水果，也常被简称为“木瓜”。");
        put("kiwi","猕猴桃（学名：Actinidia chinensis Planch），也称奇异果（奇异果是猕猴桃的一个人工选育品种，因使用广泛而成为了猕猴桃的代称）。世界猕猴桃原产地在中国湖北省宜昌市夷陵区雾渡河镇[1]  ，2008年11月6日，在新西兰举行的国际猕猴桃大会上，世界19个国家200多位专家一致认定：中国是猕猴桃的原生中心，世界猕猴桃原产地在湖北宜昌市夷陵区雾渡河镇[1]  。\n" +
                "果形一般为椭圆状，早期外观呈绿褐色，成熟后呈红褐色，表皮覆盖浓密绒毛，可食用，其内是呈亮绿色的果肉和一排黑色或者红色的种子。因猕猴喜食，故名猕猴桃；亦有说法是因为果皮覆毛，貌似猕猴而得名，是一种品质鲜嫩，营养丰富，风味鲜美的水果。\n" +
                "猕猴桃的质地柔软，口感酸甜。味道被描述为草莓、香蕉、菠萝三者的混合。猕猴桃除含有猕猴桃碱、蛋白水解酶、单宁果胶和糖类等有机物，以及钙、钾、硒、锌、锗等微量元素和人体所需17种氨基酸外，还含有丰富的维生素C、葡萄酸、果糖、柠檬酸、苹果酸、脂肪");
        put("watermelon","西瓜（学名：Citrullus lanatus (Thunb.) Matsum. et Nakai）一年生蔓生藤本；茎、枝粗壮，具明显的棱。卷须较粗壮，具短柔毛，叶柄粗，密被柔毛；叶片纸质，轮廓三角状卵形，带白绿色，两面具短硬毛，叶片基部心形。雌雄同株。雌、雄花均单生于叶腋。雄花花梗长3-4厘米，密被黄褐色长柔毛；花萼筒宽钟形；花冠淡黄色；雄蕊近离生，花丝短，药室折曲。雌花：花萼和花冠与雄花同；子房卵形，柱头肾形。果实大型，近于球形或椭圆形，肉质，多汁，果皮光滑，色泽及纹饰各式。种子多数，卵形，黑色、红色，两面平滑，基部钝圆，通常边缘稍拱起，花果期夏季。\n" +
                "中国各地栽培，品种甚多，外果皮、果肉及种子形式多样，以新疆、甘肃兰州、山东德州、江苏东台等地最为有名。其原种可能来自非洲，久已广泛栽培于世界热带到温带，金、元时始传入中国。\n" +
                "西瓜为夏季之水果，果肉味甜，能降温去暑；种子含油，可作消遣食品；果皮药用，有清热、利尿、降血压之效。");

    }};

    private List<Fruit> fruitList = new ArrayList<>();

    private FruitAdapter adapter;

    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu2);
        }
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        navView.setCheckedItem(R.id.nav_call);
        navView.setNavigationItemSelectedListener(item -> {
            drawerLayout.closeDrawers();
            return true;
        });

        FloatingActionButton floating = (FloatingActionButton) findViewById(R.id.fab);
        floating.setOnClickListener(view -> {
            Snackbar.make(view,"Data deleted",Snackbar.LENGTH_SHORT)
                    .setAction("Undo",v->{
                        Toast.makeText(MainActivity.this,"Data restored",Toast.LENGTH_SHORT).show();
                    }).show();
        });
        initFruits();
        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recycler.setLayoutManager(gridLayoutManager);
        adapter = new FruitAdapter(fruitList);
        recycler.setAdapter(adapter);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(this::refreshFruits);
    }

    private void refreshFruits(){
        new Thread(()->{
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            runOnUiThread(()->{
                initFruits();
                adapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            });
        }).start();
    }

    private void initFruits(){
        fruitList.clear();
        for (int i=0;i<50;i++){
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backup:
                Toast.makeText(this, "You cliched Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "You cliched Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "You cliched Settings", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }

}
