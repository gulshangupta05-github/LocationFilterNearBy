package `in`.surelocal.locationfilternearby

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvName =itemView.findViewById<TextView>(R.id.name)
    val tvCountry =itemView.findViewById<TextView>(R.id.country)
    val tvLatitude =itemView.findViewById<TextView>(R.id.latitude_person)
    val tvState=itemView.findViewById<TextView>(R.id.state)
}
