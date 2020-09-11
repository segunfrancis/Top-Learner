package com.project.segunfrancis.toplearner.ui.main.skilliqleaders

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import coil.api.load
import com.project.segunfrancis.toplearner.R
import com.project.segunfrancis.toplearner.data.local.models.SkillIQLeadersLocal
import com.project.segunfrancis.toplearner.databinding.ItemRecyclerviewBinding
import java.util.*

/**
 * Created by SegunFrancis
 */
class SkillIQLeadersRecyclerAdapter :
    RecyclerView.Adapter<SkillIQLeadersRecyclerAdapter.TopLearnersRecyclerViewHolder>() {

    private var data: List<SkillIQLeadersLocal> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopLearnersRecyclerViewHolder {
        return TopLearnersRecyclerViewHolder(
            ItemRecyclerviewBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: TopLearnersRecyclerViewHolder, position: Int) =
        holder.bind(data[position])

    fun setData(data: List<SkillIQLeadersLocal>) {
        this.data = data
        notifyDataSetChanged()
    }

    class TopLearnersRecyclerViewHolder(private val binding: ItemRecyclerviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SkillIQLeadersLocal) = with(binding) {
            binding.learnerImage.load(item.badgeUrl) {
                error(R.drawable.ic_broken)
            }
            binding.learnerNameText.text = item.name
            binding.learnerDetailText.text = item.score.toString().plus(" skill IQ score, ").plus(item.country)
        }
    }
}