package com.luist23.room_project.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luist23.room_project.R
import com.luist23.room_project.database.entities.GithubRepo
import kotlinx.android.synthetic.main.repo_cardview.view.*

class RepoAdapter(var repos:List<GithubRepo>) : RecyclerView.Adapter<RepoAdapter.ViewHolder>(){
    override fun getItemCount(): Int {
        return repos.size
    }

    fun updateList(newRepos:List<GithubRepo>){
        this.repos = newRepos
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repos[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.repo_cardview,parent,false)
        return  ViewHolder(view)
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(repo:GithubRepo) = with(itemView){
            this.tv_repo_name.text = repo.name
        }
    }
}