package org.thecyberspace.todolist.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_todo_list.*
import org.thecyberspace.todolist.R
class TodoListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_todo_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newToDoItem.setOnClickListener {
            toDetailsTodoList()
        }

    }

    private fun toDetailsTodoList(id : Long = 0L){
        val action:NavDirections = TodoListFragmentDirections.actionTodoListFragmentToTodoDetailsFragment()
        Navigation.findNavController(todoList).navigate(action)
    }

}