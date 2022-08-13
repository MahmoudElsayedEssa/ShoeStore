package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.viewmodels.ShoeViewModel

class ShoeListFragment : Fragment(R.layout.fragment_shoe_list) {

    private var _binding: FragmentShoeListBinding? = null
    private val binding get() = _binding!!

    //    private val shoeViewModel: ShoeViewModel by viewModels()
    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShoeListBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener {
            view?.findNavController()?.navigate(R.id.action_shoeListFragment_to_shoeDetailsFragment)
        }

        shoeViewModel.shoes.observe(viewLifecycleOwner) { shoeList ->
            if (shoeList.isNotEmpty())
                binding.emptyView.visibility = View.GONE

            shoeList.forEach { shoe ->
                val shoeItem =
                    ShoeItemBinding.inflate(LayoutInflater.from(requireContext()), null, false)

                shoeItem.shoeName.text = shoe.name
                shoeItem.description.text = shoe.description
                shoeItem.shoeSize.text = shoe.size.toString()
                shoeItem.company.text = shoe.company

                binding.linearlayoutShoelist.addView(shoeItem.root)


            }
        }
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}