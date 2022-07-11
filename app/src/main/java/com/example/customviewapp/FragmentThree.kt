package com.example.customviewapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class FragmentThree : Fragment() {

    private var screenMode = MODE_DEFAULT
    private lateinit var textViewMode: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        parseParams()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewMode = view.findViewById(R.id.fragment_text)
        when (screenMode) {
            MODE_ONE -> launchModeOne()
            MODE_TWO -> launchModeTwo()
            MODE_THREE -> launchModeThree()
        }
    }

    private fun launchModeThree() {
        textViewMode.setText(R.string.fragment_three)
    }

    private fun launchModeTwo() {
        textViewMode.setText(R.string.fragment_two)
    }

    private fun launchModeOne() {
        textViewMode.setText(R.string.fragment_one)
    }

    private fun parseParams() {
        val args = requireArguments()
        if (!args.containsKey(FRAGMENT_MODE)) {
            throw RuntimeException("No screen mode param")
        }
        val mode = args.getString(FRAGMENT_MODE)
        if (mode != MODE_ONE && mode != MODE_THREE && mode != MODE_TWO) {
            throw RuntimeException("Unknown param: screen mode $mode")
        }
        screenMode = mode
    }


    companion object {
        private const val FRAGMENT_MODE = "fragment_mode"
        private const val MODE_ONE = "one"
        private const val MODE_TWO = "two"
        private const val MODE_THREE = "three"
        private const val MODE_DEFAULT = ""

        fun newInstanceModeOne(): FragmentThree {
            return FragmentThree().apply {
                arguments = Bundle().apply {
                    putString(FRAGMENT_MODE, MODE_ONE)
                }
            }
        }

        fun newInstanceModeTwo(): FragmentThree {
            return FragmentThree().apply {
                arguments = Bundle().apply {
                    putString(FRAGMENT_MODE, MODE_TWO)
                }
            }
        }

        fun newInstanceModeThree(): FragmentThree {
            return FragmentThree().apply {
                arguments = Bundle().apply {
                    putString(FRAGMENT_MODE, MODE_THREE)
                }
            }
        }
    }
}