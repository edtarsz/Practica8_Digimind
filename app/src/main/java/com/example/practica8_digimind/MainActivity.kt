package com.example.practica8_digimind

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.practica8_digimind.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

/*
    Eduardo Talavera Ramos
    00000245244
    18/02/2025
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.fragment_dashboard)
        // segun yo el fragment dashboard está casí terminado, el problema que tengo es que si pongo el main como aparece en la presentación me crashea
        // y ya estuve como 3 horas buscando el error
        // por mi salud mental aqui la voy a dejar :(
        //setContentView(R.layout.fragment_dashboard)
    }

    /*
       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

     */
}