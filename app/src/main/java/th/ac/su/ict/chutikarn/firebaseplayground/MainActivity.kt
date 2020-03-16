package th.ac.su.ict.chutikarn.firebaseplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    val db = Firebase.firestore



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherCollection = db.collection("weather")
        val data1:MutableMap<String,Any> = HashMap()
        data1["temp"]=30
        data1["humidity"]=80

//        weatherCollection.document("wffORInrW80vP7tU7ftR").set(data1)

//        weatherCollection.add(data1)
//      weatherCollection.add(data1)
//          .addOnSuccessListener {
//              Log.d("firebase_debug",it.id)
//          }
//          .addOnFailureListener({
//
//              Log.d("firebase_debug",it.toString())
//          })

        val data2:MutableMap<String,Any> = HashMap()
        data2["temp"]=34
        data2["humidity"]=55

        weatherCollection.document("BKK").set(data2)
        val bkkDocRef = db.collection("weather").document("BKK")
        bkkDocRef.get()
            .addOnSuccessListener {
                Log.d("firebase_debug",it.data.toString())
                var temp = it["temp"]

                TVtemp.text = temp.toString()
                var hud = it["humidity"]

                TVHumidity.text = hud.toString()

            }


//
    }
}
