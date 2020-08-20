package org.thecyberspace.todolist.presentation

import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_details.*
import org.thecyberspace.core.data.TodoItem
import org.thecyberspace.todolist.R
import org.thecyberspace.todolist.framework.viewmodels.TodoDetailsViewModel

class TodoDetailsFragment : Fragment() {

    private lateinit var todoDetailsViewModel: TodoDetailsViewModel
    private val todoItem = TodoItem("" , "", 0L ,0L)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        todoDetailsViewModel = ViewModelProviders.of(this).get(TodoDetailsViewModel::class.java)

        save.setOnClickListener {
            if(title.text.toString() != "" || content.text.toString() != "")
            {
                todoItem.title = title.text.toString()
                todoItem.content = content.text.toString()

                val time : Long = System.currentTimeMillis()

                todoItem.updateTime = time

                if(todoItem.id != 0L)
                {
                    todoItem.creationTime = time
                }

                todoDetailsViewModel.saveTodoItem(todoItem)

            }else{
                Navigation.findNavController(it).popBackStack()
            }


        }
        observeViewModel()

    }

    private fun observeViewModel()
    {
        todoDetailsViewModel.saved.observe(viewLifecycleOwner, {
            if(it)
            {
                Toast.makeText(context,"Done!",Toast.LENGTH_SHORT).show()
                hideKeyBoard()
                Navigation.findNavController(title).popBackStack()
            }
            else{
                Toast.makeText(context,"Something went wrong!",Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun hideKeyBoard()
    {
        val imm = context?.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(title.windowToken,0)
    }


}