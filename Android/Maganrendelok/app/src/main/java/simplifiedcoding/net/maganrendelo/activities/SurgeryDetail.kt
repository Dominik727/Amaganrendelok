package simplifiedcoding.net.maganrendelo.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import simplifiedcoding.net.kotlinretrofittutorial.R
import simplifiedcoding.net.maganrendelo.data.SurgeryAdapter
import simplifiedcoding.net.maganrendelo.models.Surgery

class SurgeryDetail : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "name"


    fun newIntent(context: Context, surgery: Surgery): Intent {
            val detailIntent = Intent(context, SurgeryDetail::class.java)

            detailIntent.putExtra(EXTRA_TITLE, surgery.name)

            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surgerydetail)
        


    }




}
