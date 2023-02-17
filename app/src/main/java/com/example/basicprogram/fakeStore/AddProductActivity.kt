package com.example.basicprogram.fakeStore


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import com.basgeekball.awesomevalidation.AwesomeValidation
import com.basgeekball.awesomevalidation.ValidationStyle
import com.basgeekball.awesomevalidation.utility.RegexTemplate
import com.example.basicprogram.R
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*


class AddProductActivity : AppCompatActivity()  {

    lateinit var categoryItem: CategoryItem
    lateinit var spinner: AutoCompleteTextView
    private lateinit var saveImageView: ImageView
    private lateinit var backArrow: ImageView
    private lateinit var title: TextInputEditText
    private lateinit var price: TextInputEditText
    private lateinit var description: TextInputEditText
    private lateinit var awesomeValidation: AwesomeValidation
    lateinit var progressBar: ProgressBar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)

        awesomeValidation = AwesomeValidation(ValidationStyle.BASIC)

        progressBar=findViewById(R.id.progressbar)
        title = findViewById(R.id.txtInputTitle)
        price = findViewById(R.id.txtInputPrice)
        description = findViewById(R.id.txtInputDesc)

        //Get Category Data Using Spinner
        spinner = findViewById(R.id.txtInputCategory)

        getCategoryData()

        backArrow = findViewById(R.id.imgBack)
        backArrow.setOnClickListener {
            val intent = Intent(this, FakeStoreActivity::class.java)
            startActivity(intent)
            finishAffinity()
        }


        //Save Button
        saveImageView = findViewById(R.id.imgSave)
        saveImageView.setOnClickListener {
            if (awesomeValidation.validate()) {
                val intent = Intent(this, FakeStoreActivity::class.java)
                startActivity(intent)
                finishAffinity()
            }
        }

        setError()
    }


    private fun setError() {

        awesomeValidation.addValidation(this,
            R.id.new_product_title,
            RegexTemplate.NOT_EMPTY,
            R.string.title_error)
        awesomeValidation.addValidation(this,
            R.id.new_product_price,
            RegexTemplate.NOT_EMPTY,
            R.string.price_error)
        awesomeValidation.addValidation(this,
            R.id.new_product_desc,
            RegexTemplate.NOT_EMPTY,
            R.string.description_error)
         /*awesomeValidation.addValidation(this,
             R.id.txtInputCategory,
              RegexTemplate.NOT_EMPTY,
             R.string.category_error)*/

    }

    //Call Category Api in Spinner
    private fun getCategoryData() {
        progressBar.isGone=false
        val fakeStoreApi = FakeStoreObject.getFakeStoryObject().create(FakeStoreApi::class.java)

        val call: Call<CategoryItem> = fakeStoreApi.getCategory()

        call.enqueue(object : Callback<CategoryItem> {
            override fun onResponse(
                call: Call<CategoryItem>,
                response: Response<CategoryItem>,
            ) {
                if (response.isSuccessful) {
                    progressBar.isGone=true
                    categoryItem = response.body()!!
                    val adapter = ArrayAdapter(
                        this@AddProductActivity,
                        R.layout.category_item_list,
                        categoryItem)
                    spinner.setAdapter(adapter)

                }
            }

            override fun onFailure(call: Call<CategoryItem>, t: Throwable) {
                Toast.makeText(this@AddProductActivity, "Category not shown..", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}