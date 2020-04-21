package simplifiedcoding.net.kotlinretrofittutorial.storage

import android.content.Context
import simplifiedcoding.net.kotlinretrofittutorial.models.Patient


class SharedPrefManager private constructor(private val mCtx: Context) {

    val isLoggedIn: Boolean
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return sharedPreferences.getInt("id", -1) != -1
        }

    val user: Patient
        get() {
            val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
            return Patient(
                    sharedPreferences.getInt("id", -1),
                    sharedPreferences.getString("firstname", null),
                    sharedPreferences.getString("lastname", null),
                    sharedPreferences.getString("email", null),
                    sharedPreferences.getString("tel", null),
                    sharedPreferences.getString("taj", null),
                    sharedPreferences.getString("pass", null)
            )
        }


    fun saveUser(user: Patient) {

        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("firstname", user.firstname)
        editor.putString("lastname", user.lastname)
        editor.putString("email", user.email)
        editor.putString("tel", user.tel)
        editor.putString("taj", user.taj)
        editor.putString("pass", user.pass)

        editor.apply()

    }

    fun clear() {
        val sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        private val SHARED_PREF_NAME = "my_shared_preff"
        private var mInstance: SharedPrefManager? = null
        @Synchronized
        fun getInstance(mCtx: Context): SharedPrefManager {
            if (mInstance == null) {
                mInstance = SharedPrefManager(mCtx)
            }
            return mInstance as SharedPrefManager
        }
    }

}