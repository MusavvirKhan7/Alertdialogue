package com.example.dialoguebox

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewbinding.ViewBinding
import com.example.dialoguebox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you sure?")
            builder1.setMessage("Do you want to close the app?")
            builder1.setIcon(R.drawable.baseline_auto_delete_24)
            builder1.setPositiveButton("YES", DialogInterface.OnClickListener { dialog, which ->
            //what action should be performed when yes is clicked
            finish()   })
            builder1.setNegativeButton("NO", DialogInterface.OnClickListener { dialog, which ->  } )
            //what action is performed when no is clicked ?
            builder1.show()
        }

          binding.button2.setOnClickListener{
              val option = arrayOf("Gulab Jamun", "Rasgulla", "Kunafa", "Rasmalai")
              val builder2 = AlertDialog.Builder(this)
              builder2.setTitle("Which one of these is your favourite?")
              builder2.setSingleChoiceItems(option, 0, DialogInterface.OnClickListener { dialog, which ->
              //  What action is to be performed when user clicks one of the options
                  Toast.makeText(this, "You clicked on ${option[which]}", Toast.LENGTH_SHORT).show()
              })
              builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                  //what action should be performed when yes is clicked
                   })
              builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which ->  } )
              //what action is performed when no is clicked ?
              builder2.show()
          }

          binding.button3.setOnClickListener{
              val option = arrayOf("Gulab Jamun", "Rasgulla", "Kunafa", "Rasmalai")
              val builder2 = AlertDialog.Builder(this)
              builder2.setTitle("Which one of these is your favourite?")
              builder2.setMultiChoiceItems(option, null, DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                  //  What action is to be performed when user clicks one of the options
                  Toast.makeText(this, "You clicked on ${option[which]}", Toast.LENGTH_SHORT).show() })

              builder2.setPositiveButton("Submit", DialogInterface.OnClickListener { dialog, which ->
                  //what action should be performed when yes is clicked
              })
              builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which ->  } )
              //what action is performed when no is clicked ?
              builder2.show()
          }
          }

    }