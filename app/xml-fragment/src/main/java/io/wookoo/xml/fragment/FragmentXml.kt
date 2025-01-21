package io.wookoo.xml.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.wookoo.xml.fragment.databinding.FragmentLegacyBinding

class FragmentXml : Fragment() {

    private var _binding: FragmentLegacyBinding? = null
    private val binding: FragmentLegacyBinding
        get() = checkNotNull(_binding)

    private var onBackIconClickListener: (() -> Unit)? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLegacyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            tvArgs.text = requireArguments().getString(ARG)
            button.setOnClickListener {
                onBackIconClickListener?.invoke()
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    fun setOnBackIconClickListener(listener: () -> Unit) {
        onBackIconClickListener = listener
    }

    companion object {
        const val ARG = "arg"
    }

}