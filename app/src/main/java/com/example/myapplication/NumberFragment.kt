package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentNumberBinding


class NumberFragment : Fragment() {

    lateinit var binding: FragmentNumberBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNumberBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            button.setOnClickListener {

                if (number.text.isEmpty()) {
                    Toast.makeText(context, "Please Enter Number", Toast.LENGTH_LONG).show()

                } else {

                    val action = NumberFragmentDirections.actionNumberFragmentToPowFragment().setValue(number.text.toString().toInt())
                    findNavController().navigate(action)
                }
            }
        }
    }

}