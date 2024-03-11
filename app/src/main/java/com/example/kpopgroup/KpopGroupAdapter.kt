import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kpopgroup.KpopGroup
import com.example.kpopgroup.R

class KpopGroupAdapter(private val kpopGroups: List<KpopGroup>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<KpopGroupAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val groupName: TextView = itemView.findViewById(R.id.groupName)
        val groupImage: ImageView = itemView.findViewById(R.id.groupImage)
        val groupDescription: TextView = itemView.findViewById(R.id.groupDescription)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_kpop, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val group = kpopGroups[position]
        holder.groupName.text = group.name
        holder.groupImage.setImageResource(group.imageResId)
        holder.groupDescription.text = group.description

//        holder.itemView.setOnClickListener{
//            Toast.makeText(holder.itemView.context, "Kamu memilih " + kpopGroups[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
//        }
    }

    override fun getItemCount(): Int {
        return kpopGroups.size
    }

    fun getItemAtPosition(position: Int): KpopGroup {
        return kpopGroups[position]
    }
}
