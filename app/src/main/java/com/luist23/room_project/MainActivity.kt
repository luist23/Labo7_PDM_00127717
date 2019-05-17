package com.luist23.room_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.luist23.room_project.adapters.RepoAdapter
import com.luist23.room_project.database.entities.GithubRepo
import com.luist23.room_project.database.viewmodels.GithubRepoViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter: RepoAdapter
    lateinit var viewModel:GithubRepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bind()
    }

    fun bind(){
        adapter= RepoAdapter(ArrayList())
        viewModel = ViewModelProviders.of(this).get(GithubRepoViewModel::class.java)
        rv_repo.apply {
            adapter=this@MainActivity.adapter
            layoutManager=LinearLayoutManager(this@MainActivity)
        }

        viewModel.getAll().observe(this, Observer {
            adapter.updateList(it)
        })

        btn_add.setOnClickListener {
            viewModel.insert(GithubRepo((et_repo.text.toString())))
        }
    }


}
