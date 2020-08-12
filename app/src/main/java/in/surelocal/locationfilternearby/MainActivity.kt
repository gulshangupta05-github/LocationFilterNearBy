package `in`.surelocal.locationfilternearby

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.google.type.LatLng
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.*
import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity()   {

    lateinit var firestore: FirebaseFirestore

    private var mDatas = ArrayList<UserInfo>()

        var lat = 26.8454348
    var lng  = 80.9368003

    var currentLoc: LatLng? = null

    fun MainActivity(current: LatLng) {
        currentLoc = current

    }


    //    var latLng:LatLng(lat,lng)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mData = ArrayList<UserInfo>()
//        val places=ArrayList<UserInfo>()



        mData.add(
            UserInfo(
                latitude = "26.8579474 80.9277478"
            )
        )
        mData.add(
            UserInfo(
                latitude = "26.8511857 80.9299776"
            )
        )
        mData.add(
            UserInfo(
                latitude = "26.8499037 80.9316144"
            )
        )
        mData.add(
            UserInfo(
                latitude = "26.8472855 80.9330934"
            )
        )
        mData.add(
            UserInfo(
                latitude = "26.8472303 80.9332934"
            )
        )
        mData.add(
            UserInfo(
                latitude = "26.8472476 80.9333945"
            )
        )
        mData.add(
            UserInfo(
                latitude = "26.8480333 80.9330364"
            )
        )
        mData.add(
            UserInfo(
                latitude = "26.8500395 80.9311748"
            )
        )
        mData.add(
            UserInfo(
                latitude = "26.8495204 80.9313353"
            )
        )
        mData.add(
            UserInfo(
                latitude = "26.8426598 80.9276222"
            )
        )
        mData.add(
            UserInfo(
                latitude = "26.838552 80.9310544"
            )
        )
        mData.add(
            UserInfo(
                latitude = "26.8383501 80.9303141"
            )
        )
        mData.add(
            UserInfo(
                latitude = "26.8386535 80.9304834"
            )
        )
        mData.add(
            UserInfo(
                latitude = "26.8386053 80.9305593"
            )
        )
        mData.add(
            UserInfo(
                latitude = "26.8376857 80.9310348"
            )
        )


        for (p in mData) {
            Log.i("Places before sorting", "Place: " + p.latitude)
        }


//        Collections.sort (mData,  UserInfo?(lat.compareTo(lng)))


        for (p in mData) {
            Log.i("Places after sorting", "Place: " + p.latitude)
        }

        recycler_view.layoutManager = StaggeredGridLayoutManager(1, RecyclerView.VERTICAL)
        calculateDistance(26.8454348, 80.9368003, 26.8386535, 80.9304834)
//        calculateDistance()
        recycler_view.adapter = MyAdapter(mData)

        Log.d(
            TAG,
            "Distance : ${calculateDistance(26.8459246, 80.9369289, 26.8386535, 80.9304834)}"
        )
        Log.d(
            TAG,
            "Distance 2 :${calculateDistance(26.8459246, 80.9369289, 26.8520205, 80.9391940)}"
        )
        Log.d(
            TAG,
            "Distance 2 :${calculateDistance(26.8459246, 80.9369289, 26.4473103, 80.2683428)}"
        )
        Log.d(
            TAG,
            "Distance 2 :${calculateDistance(26.8459246, 80.9369289, 26.8520205, 80.9391940)}"
        )
        Log.d(
            TAG,
            "Distance 2 :${calculateDistance(26.8459246, 80.9369289, 28.5274851, 77.1389452)}"
        )




//        firestore = FirebaseFirestore.getInstance()
//        firestore.collection("RetroFit Fetch Data").get()
//            .addOnSuccessListener {
////                it.forEach {
////                    val document_id = it.id
//                val data = it.toObjects(UserInfo::class.java)
////                    mDatas.add(
////                        UserInfo(
//////                            document_id = document_id,
////                        )
////                    )
////                }
//                storeData(data)
//                Log.d(TAG, "success:")
//            }
//            .addOnFailureListener {
//                Log.d(TAG, "failed : ${it.message}")
//            }


    }

//    private fun storeData(data: List<UserInfo>) {
//        for (i in data) {
//            mDatas.add(i)
//        }
//        recycler_view.adapter = MyAdapter(mDatas)
//    }


//
//    override fun compare(place1: Log?, place2: Log?): Int {
//        val lat1: Double = place1
//        val lon1: Double = place1.latlng.longitude
//        val lat2: Double = place2.latlng.latitude
//        val lon2: Double = place2.latlng.longitude
//}
}
private fun calculateDistance(
    lat1: Double,
    lon1: Double,
    lat2: Double,
    lon2: Double
): Double {
    val R = 6371  // Radius of the earth in km
    val dLat = deg2red(lat2 - lat1)  // deg2rad below
    val dLon = deg2red(lon2 - lon1)
    val a =
        sin(dLat / 2) * sin(dLat / 2) + cos(lat1) *
                cos(lat2) * sin(dLon / 2) *
                sin(dLon / 2)
    val c = 2 * atan2(sqrt(a), sqrt(1 - a))
    val d = R * c   // Distance in km
    return d
}
private fun deg2red(deg: Double): Double {
    return deg * (Math.PI / 180)
}






