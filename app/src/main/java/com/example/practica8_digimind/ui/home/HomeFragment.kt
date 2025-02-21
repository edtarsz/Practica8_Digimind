package com.example.practica8_digimind.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.practica8_digimind.R
import com.example.practica8_digimind.Task

/*
    Eduardo Talavera Ramos
    00000245244
    18/02/2025
 */
class HomeFragment : Fragment() {

    companion object {
        var tasks = ArrayList<Task>()
        var first = true
    }

    private var adaptador: AdaptadorTareas? = null
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container)

        if(first){
            fillTasks()
            first = false
        }

        val grid = root.findViewById<GridView>(R.id.gridview)

        adaptador = AdaptadorTareas(root.context, tasks)
        grid.adapter = adaptador

        return root
    }

    fun fillTasks(){
        tasks.add(Task("Practice 1", arrayListOf("Tuesday"), "17:30"))
        tasks.add(Task("Practice 2", arrayListOf("Monday", "Sunday"), "17"))
        tasks.add(Task("Practice 3", arrayListOf("Saturday"), "14:00"))
        tasks.add(Task("Practice 4", arrayListOf("Friday"), "11:30"))
        tasks.add(Task("Practice 5", arrayListOf("Thursday"), "13:30"))
        tasks.add(Task("Practice 6", arrayListOf("Monday"), "12:30"))
        tasks.add(Task("Practice 7", arrayListOf("Wednesday"), "12:00"))
    }

    private class AdaptadorTareas: BaseAdapter {
        var tasks = ArrayList<Task>()
        var contexto: Context? = null

        constructor(contexto: Context, tasks: ArrayList<Task>){
            this.contexto = contexto
            this.tasks = tasks
        }

        override fun getCount(): Int {
            return tasks.size
        }

        override fun getItem(position: Int): Any {
            return tasks[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var task = tasks[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.task_view, null)

            val tvTitle = vista.findViewById<TextView>(R.id.tv_title)
            val tvTime = vista.findViewById<TextView>(R.id.tv_time)
            val tvDays = vista.findViewById<TextView>(R.id.tv_days)

            tvTitle.text = task.title
            tvTime.text = task.time
            tvDays.text = task.days.toString()

            return vista
        }
    }
}