package com.example.practica8_digimind.ui.dashboard

import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.practica8_digimind.R
import com.example.practica8_digimind.Task
import com.example.practica8_digimind.databinding.FragmentDashboardBinding
import com.example.practica8_digimind.ui.home.HomeFragment
import java.text.SimpleDateFormat

/*
    Eduardo Talavera Ramos
    00000245244
    18/02/2025
 */
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this)[DashboardViewModel::class.java]

        val root = inflater.inflate(R.layout.fragment_dashboard, container)

        val btn_time : Button = root.findViewById(R.id.btn_time)
        val btn_save : Button = root.findViewById(R.id.btn_save)

        val checkMonday : CheckBox = root.findViewById(R.id.checkMonday)
        val checkTuesday : CheckBox = root.findViewById(R.id.checkTuesday)
        val checkWednesday : CheckBox = root.findViewById(R.id.checkWednesday)
        val checkThursday : CheckBox = root.findViewById(R.id.checkThursday)
        val checkFriday : CheckBox = root.findViewById(R.id.checkFriday)
        val checkSatuday : CheckBox = root.findViewById(R.id.checkSaturday)
        val checkSunday : CheckBox = root.findViewById(R.id.checkSunday)

        val title : EditText = root.findViewById(R.id.do_title)


        btn_time.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)

                btn_time.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(root.context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), true).show()
        }

        btn_save.setOnClickListener{
            var title = title.text.toString()
            var time = btn_time.text.toString()
                
            var days = ArrayList<String>()

            if (checkMonday.isChecked) days.add("Monday")
            if (checkTuesday.isChecked) days.add("Tuesday")
            if (checkWednesday.isChecked) days.add("Wednesday")
            if (checkThursday.isChecked) days.add("Thursday")
            if (checkFriday.isChecked) days.add("Friday")
            if (checkSatuday.isChecked) days.add("Saturday")
            if (checkSunday.isChecked) days.add("Sunday")

            var task= Task(title, days, time)
            HomeFragment.tasks.add(task)
            Toast.makeText(root.context, "new task added", Toast.LENGTH_SHORT).show()
        }

        return root
    }
}