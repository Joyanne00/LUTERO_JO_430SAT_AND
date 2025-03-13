package com.rigcpstone.multilayoutlogger

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class RecipeListActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "RecipeListActivityLog"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        Log.d(TAG, "RecipeListActivity Loaded")
    }

    fun openRecipeDetail(view: View) {
        val intent = Intent(this, RecipeDetailActivity::class.java)
        intent.putExtra("RECIPE_NAME", view.tag.toString()) // Pass recipe name
        startActivity(intent)
    }
}
