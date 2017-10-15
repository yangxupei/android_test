package com.example.yang.winx;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements OnClickListener {
	private ViewPager mViewPager;
	private PagerAdapter mAdapter;
	private List<View> mViews = new ArrayList<View>();//??????????????????????4???????view
	//????????tab???????????????????????
	private LinearLayout mTabWeixin;
	private LinearLayout mTabFrd;
	private LinearLayout mTabAddress;
	private LinearLayout mTabSetting;
	
	private ImageButton mWeixinImg;
	private ImageButton mFrdImg;
	private ImageButton mAddressImg;
	private ImageButton mSettingImg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();
		initEvents();
	}

	private void initEvents() {
		//???????4??LinearLayout??4?????????????????
		mTabWeixin.setOnClickListener(this);
		mTabFrd.setOnClickListener(this);
		mTabAddress.setOnClickListener(this);
		mTabSetting.setOnClickListener(this);
		//viewpager???????
		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {//??viewpager???????????????????????????��
				int currentItem = mViewPager.getCurrentItem();
				resetImg();
				switch (currentItem) {
				case 0:
					mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);
					break;
				case 1:
					mFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
					break;
				case 2:
					mAddressImg.setImageResource(R.drawable.tab_address_pressed);
					break;
				case 3:
					mSettingImg.setImageResource(R.drawable.tab_settings_pressed);
					break;

				default:
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void initView() {//????????��?view
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		//tabs
		mTabWeixin = (LinearLayout) findViewById(R.id.id_tab_weixin);
		mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
		mTabAddress = (LinearLayout) findViewById(R.id.id_tab_address);
		mTabSetting = (LinearLayout) findViewById(R.id.id_tab_setting);
		//imagebutton
		mWeixinImg = (ImageButton)findViewById(R.id.id_tab_weixin_img);
		mFrdImg = (ImageButton)findViewById(R.id.id_tab_frd_img);
		mAddressImg = (ImageButton)findViewById(R.id.id_tab_address_img);
		mSettingImg = (ImageButton)findViewById(R.id.id_tab_setting_img);
		//???LayoutInflater???????????????????view
		LayoutInflater mInflater = LayoutInflater.from(this);//???????LayoutInflater????
		View tab01 = mInflater.inflate(R.layout.tab01, null);//???inflate?????????????????????
		View tab02 = mInflater.inflate(R.layout.tab02, null);
		View tab03 = mInflater.inflate(R.layout.tab03, null);
		View tab04 = mInflater.inflate(R.layout.tab04, null);
		mViews.add(tab01);
		mViews.add(tab02);
		mViews.add(tab03);
		mViews.add(tab04);
		//?????PagerAdapter
		mAdapter = new PagerAdapter() {


			@Override
			public void destroyItem(ViewGroup container, int position,
                                    Object object) {
				// TODO Auto-generated method stub
				container.removeView(mViews.get(position));
			}

			@Override
			public Object instantiateItem(ViewGroup container, int position) {
				View view = mViews.get(position);//??mViews???list?��???��??????????????view
				container.addView(view);//????????view????ViewGroup??
				return view;
			}

			/*
			 * isViewFromObject?????��?instantiateItem(ViewGroup, int)??????????????Key???????????????????
			 * ?????????(???????????????????????????View),??????????????View??????True???????False
			 * */
			@Override
			public boolean isViewFromObject(View arg0, Object arg1) {
				// TODO Auto-generated method stub
				return arg0 == arg1;
			}

			@Override
			public int getCount() {
				// ????PagerView??????view?????
				return mViews.size();
			}
		};
		//?ViewPager????adapter
		mViewPager.setAdapter(mAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		resetImg();
		switch (v.getId()) {
		case R.id.id_tab_weixin:
			mViewPager.setCurrentItem(0);
			mWeixinImg.setImageResource(R.drawable.tab_weixin_pressed);//??????????????
			break;
		case R.id.id_tab_frd:
			mViewPager.setCurrentItem(1);
			mFrdImg.setImageResource(R.drawable.tab_find_frd_pressed);
			break;
		case R.id.id_tab_address:
			mViewPager.setCurrentItem(2);
			mAddressImg.setImageResource(R.drawable.tab_address_pressed);
			break;
		case R.id.id_tab_setting:
			mViewPager.setCurrentItem(3);
			mSettingImg.setImageResource(R.drawable.tab_settings_pressed);
			break;

		default:
			break;
		}

	}
	/*
	 * ?????��???????????
	 * */
	private void resetImg() {
		mWeixinImg.setImageResource(R.drawable.tab_weixin_normal);
		mFrdImg.setImageResource(R.drawable.tab_find_frd_normal);
		mAddressImg.setImageResource(R.drawable.tab_address_normal);
		mSettingImg.setImageResource(R.drawable.tab_settings_normal);
		
	}
}
