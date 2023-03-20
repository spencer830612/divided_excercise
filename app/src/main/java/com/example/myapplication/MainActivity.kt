package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.myapplication.databinding.ActivityMainBinding // 要加

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding /* 要加的。如在選單出來時直接選，會自動加入必要的 import
     我們真正要建立的元件是在 Layout，如果在 Gradle 先設定，就可以再引用元件的 ID。
     Binding 的意義是把「值」動態設定過來，把在 Layout 的值存到 binding
     這種的 assign 有動態的概念。當東西部有更動時，可以自動更新到 binding 裡。
     Private 代表這個變數只能用在這個大刮號裡
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // 原本的
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this)) //要加的
        // inflater 類似於載入器
        // this 代表這頁的 Layout 檔案
        setContentView(binding.root) //要加的
        /* 設定這頁的畫面給大家看，然後畫面放在 binding 裡的 root
         為何用 root？因為 root 代表階層架構的最上層
         如果只想展示 buttom ，那麼就是用 setContentView(binding.btDivide)
         如果你不重複打 binding，你可以使用

        with(binding){
            ......
        }

        裡面的 binding. 都不用再輸入了，讚。binding.upper.text.toString().toInt() 就可以只輸入 upper.text.toString().toInt()
        */

        binding.btDivide.setOnClickListener {
        // setOnClickListener 就是請 Android 去監控此按鈕的點擊狀況
        val u = binding.upper.text.toString().toInt()
        val l = binding.lowwer.text.toString().toInt()
        // 原本的 text 的型態是 editable，不是 String。
        val text =
            if (u >= 20000){
                if (l >= 5) "可以去泰國玩"
                else "有錢沒閒"
            }
            else {
                if(l >= 5) "有閒沒錢"
                else "沒錢沒閒，真可憐"
            }

        binding.textView.text = text
        // 最後把 text 的內容回傳給 textView 的 text 裡
        }

         binding.buttonSeason.setOnClickListener {
             val text1 = when(binding.textSeason.text.toString()){
                     "春" -> "春暖花開"
                     "夏" -> "夏日炎炎"
                     "秋" -> "秋高氣爽"
                     "冬" -> "冬方凜冽"
                     else -> "輸入錯誤"
                 }
             binding.ShowSeason.text = text1
         }
    }
}