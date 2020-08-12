package `in`.surelocal.locationfilternearby

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val mDatas: ArrayList<UserInfo>) : RecyclerView.Adapter<MyViewHolder>() {
    private   val TAG = "MyAdapter"
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_recyclerview, parent, false))
    }
    override fun getItemCount()=mDatas.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvLatitude.text = mDatas[position].latitude
//        holder.tvName.text = mDatas[position].name
//        holder.tvCountry.text = mDatas[position].country
//        holder.tvState.text = mDatas[position].state

        Log.d(TAG, "onBindViewHolder: $mDatas")

    }


}