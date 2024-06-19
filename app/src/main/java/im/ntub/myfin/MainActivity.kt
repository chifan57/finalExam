//組員:11056004石之昀、11056014伍紀帆

package im.ntub.myfin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPagerAdapter = ViewPagerAdopter(this)
        val viewPager = findViewById<ViewPager2>(R.id.mViewPageNav)
        val btnNav=findViewById<BottomNavigationView>(R.id.btnNav)
        viewPager.adapter = viewPagerAdapter

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                btnNav.selectedItemId = when(position) {
                    0 -> R.id.btnRight
                    1 -> R.id.btnMid
                    else -> R.id.btnRight
                }
            }
        })
        findViewById<BottomNavigationView>(R.id.btnNav).setOnItemSelectedListener(
            NavigationBarView.OnItemSelectedListener {
                when(it.itemId){
                    R.id.btnLeft -> {
                        viewPager.currentItem = 0
                        return@OnItemSelectedListener true
                    }
                    R.id.btnMid ->{
                        viewPager.currentItem = 1
                        return@OnItemSelectedListener true
                    }
                    R.id.btnRight ->{
                        viewPager.currentItem = 2
                        return@OnItemSelectedListener true
                    }
                }
                false
            })



    }
}

class ViewPagerAdopter(activity: MainActivity):FragmentStateAdapter(activity){
    override fun getItemCount()=3

    override fun createFragment(position: Int)= when(position) {
        0 ->FirstFragment.newInstance("","")
        1 ->SecondFragment.newInstance("","")
        else ->ThirdFragment()
    }
}