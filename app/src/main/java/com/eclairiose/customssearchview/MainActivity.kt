package com.eclairiose.customssearchview

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.eclairiose.customssearchview.Prefrences.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_item.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    private var people: ArrayList<Person> = arrayListOf()
    private var matchedPeople: ArrayList<Person> = arrayListOf()
    private var personAdapter: PersonAdapter = PersonAdapter(people)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        performSearch()

        //    setupTaskRecyclerView()
        if (!AppNotInstalled(this, "app")) {
            isAppInstalled(this, "app", true)
        } else {
            namad.isChecked = getName(this, "name")
            date.isChecked = getDate(this, "date")
            ascending.isChecked = getAscendinging(this, "asc")
            decending.isChecked = getDescending(this, "dec")
        }

        sorting.setOnClickListener {
            showPopup()
        }
    }

    private fun setupTaskRecyclerView() {

        recyclerView.setHasFixedSize(true)

        people.sortBy { it.name }
        val taskAdapter = PersonAdapter(people)
        recyclerView.adapter = taskAdapter
        recyclerView.adapter!!.notifyDataSetChanged()

    }


    private fun initRecyclerView() {

        people = arrayListOf(
            Person("Eric G", 19),
            Person("Reen", 19),
            Person("Jeff", 21),
            Person("Geoffrey", 19),
            Person("Lorem ipsum", 35),
            Person("Paul N", 23),
            Person("Diana", 20),
            Person("Peter", 24),
            Person("Amos", 41),
            Person("Steve", 17),
        )

        personAdapter = PersonAdapter(people).also {
            recyclerView.adapter = it
            recyclerView.adapter!!.notifyDataSetChanged()
        }
        searchView.isSubmitButtonEnabled = true
    }

    private fun performSearch() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                search(newText)
                return true
            }
        })
    }

    private fun search(text: String?) {
        matchedPeople = arrayListOf()

        text?.let {
            people.forEach { person ->
                if (person.name.contains(text, true) ||
                    person.age.toString().contains(text, true)
                ) {
                    matchedPeople.add(person)
                }
            }
            updateRecyclerView()
            if (matchedPeople.isEmpty()) {
                Toast.makeText(this, "No match found!", Toast.LENGTH_SHORT).show()
            }
            updateRecyclerView()
        }

    }

    private fun updateRecyclerView() {
        recyclerView.apply {
            personAdapter.list = matchedPeople
            personAdapter.notifyDataSetChanged()
        }
    }

    private fun showPopup() {
        linear1.visibility = View.VISIBLE

        //on click item radio gruop color
        rdg_main_color.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.namad -> {

                    date.isChecked = false
                    saveName(this, "name", true)
                    saveDate(this, "date", false)
                }
                R.id.date -> {
                    namad.isChecked = false

                    saveName(this, "name", false)
                    saveDate(this, "date", true)
                }
            }
        }


        //on click item radio gruop name
        rdg_main_name.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.ascending -> {
                    decending.isChecked = false

                    Timer("SettingUp", false).schedule(1500) {
                        linear1.visibility = View.INVISIBLE
                    }

                    if(namad.isChecked){
                        ascendingWithNames()
                    }else{
                        ascendingWithDates()
                    }

                    saveAscending(this, "asc", true)
                    saveDescending(this, "dec", false)

                }
                R.id.decending -> {
                    ascending.isChecked = false

                    Timer("SettingUp", false).schedule(1500) {
                        linear1.visibility = View.INVISIBLE
                    }

                    if(namad.isChecked){
                        decendingWithNames()
                    }else{
                        decendingWithDates()
                    }

                    saveAscending(this, "asc", false)
                    saveDescending(this, "dec", true)

                }
            }
        }
    }

    private fun ascendingWithNames() {
        Toast.makeText(applicationContext,"ascending with names",Toast.LENGTH_SHORT).show()


        recyclerView.setHasFixedSize(true)

        people.sortBy { it.name }
        val taskAdapter = PersonAdapter(people)
        recyclerView.adapter = taskAdapter
        recyclerView.adapter!!.notifyDataSetChanged()
    }


    private fun ascendingWithDates() {
        Toast.makeText(applicationContext,"ascending with dates",Toast.LENGTH_SHORT).show()

    }


    private fun decendingWithNames() {
        Toast.makeText(applicationContext,"decending with names",Toast.LENGTH_SHORT).show()
        recyclerView.setHasFixedSize(true)

        people.sortByDescending { it.name }
        val taskAdapter = PersonAdapter(people)
        recyclerView.adapter = taskAdapter
        recyclerView.adapter!!.notifyDataSetChanged()
    }

    private fun decendingWithDates() {
        Toast.makeText(applicationContext,"decending with dates",Toast.LENGTH_SHORT).show()
    }


}